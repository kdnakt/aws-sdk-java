/*
 * Copyright (c) 2016. Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.codegen.customization.processors;

import com.amazonaws.codegen.customization.CodegenCustomizationProcessor;
import com.amazonaws.codegen.model.intermediate.IntermediateModel;
import com.amazonaws.codegen.model.intermediate.MemberModel;
import com.amazonaws.codegen.model.intermediate.ShapeModel;
import com.amazonaws.codegen.model.service.ServiceModel;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final public class SupressEnumSetterProcessor implements
                                              CodegenCustomizationProcessor {

    private final Map<String, List<String>> suppressEnumSetterFor;

    public SupressEnumSetterProcessor(Map<String, List<String>> suppressEnumSetterFor) {
        this.suppressEnumSetterFor = suppressEnumSetterFor;
    }


    @Override
    public void preprocess(ServiceModel serviceModel) {
        // do nothing
    }

    @Override
    public void postprocess(IntermediateModel intermediateModel) {
        if (suppressEnumSetterFor == null || suppressEnumSetterFor.isEmpty()) {
            return;
        }

        sanityCheck(intermediateModel);

        for (Entry<String, List<String>> entry : suppressEnumSetterFor.entrySet()) {
            String shapeName = entry.getKey();
            List<String> members = entry.getValue();

            ShapeModel shapeModel = intermediateModel.getShapes().get(shapeName);
            for (String memberName : members) {
                MemberModel memberModel = shapeModel.getMemberByName(memberName);
                memberModel.setShouldSupressEnumSetter(true);
            }
        }
    }

    /**
     * Verify the shape exists and the members provided exist and also verify the members
     * are list shapes.
     */
    private void sanityCheck(IntermediateModel intermediateModel) {
        for (Entry<String, List<String>> entry : suppressEnumSetterFor.entrySet()) {
            String shapeName = entry.getKey();
            List<String> members = entry.getValue();

            ShapeModel shapeModel = intermediateModel.getShapes().get(shapeName);
            if (shapeModel == null) {
                throw new IllegalStateException(
                        String.format("Cannot find shape [%s] in the model when processing "
                                      + "customization config sendEmptyQueryStringParam.%s", shapeName, shapeName));
            }
            for (String memberName : members) {
                MemberModel memberModel = shapeModel.getMemberByName(memberName);
                if (memberModel == null) {
                    throw new IllegalStateException(
                            String.format("Cannot find member [%s] in the model when processing "
                                          + "customization config sendEmptyQueryStringParam.%s", memberName, shapeName));
                }
            }
        }
    }

}