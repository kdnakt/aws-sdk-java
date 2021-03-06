/*
 * Copyright 2015-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.augmentedairuntime.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * <p>
 * Information about where the human output will be stored.
 * </p>
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/sagemaker-a2i-runtime-2019-11-07/HumanLoopOutputContent"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class HumanLoopOutputContent implements Serializable, Cloneable, StructuredPojo {

    /**
     * <p>
     * The location of the Amazon S3 object where Amazon Augmented AI stores your human loop output. The output is
     * stored at the following location: <code>s3://S3OutputPath/HumanLoopName/CreationTime/output.json</code>.
     * </p>
     */
    private String outputS3Uri;

    /**
     * <p>
     * The location of the Amazon S3 object where Amazon Augmented AI stores your human loop output. The output is
     * stored at the following location: <code>s3://S3OutputPath/HumanLoopName/CreationTime/output.json</code>.
     * </p>
     * 
     * @param outputS3Uri
     *        The location of the Amazon S3 object where Amazon Augmented AI stores your human loop output. The output
     *        is stored at the following location: <code>s3://S3OutputPath/HumanLoopName/CreationTime/output.json</code>
     *        .
     */

    public void setOutputS3Uri(String outputS3Uri) {
        this.outputS3Uri = outputS3Uri;
    }

    /**
     * <p>
     * The location of the Amazon S3 object where Amazon Augmented AI stores your human loop output. The output is
     * stored at the following location: <code>s3://S3OutputPath/HumanLoopName/CreationTime/output.json</code>.
     * </p>
     * 
     * @return The location of the Amazon S3 object where Amazon Augmented AI stores your human loop output. The output
     *         is stored at the following location:
     *         <code>s3://S3OutputPath/HumanLoopName/CreationTime/output.json</code>.
     */

    public String getOutputS3Uri() {
        return this.outputS3Uri;
    }

    /**
     * <p>
     * The location of the Amazon S3 object where Amazon Augmented AI stores your human loop output. The output is
     * stored at the following location: <code>s3://S3OutputPath/HumanLoopName/CreationTime/output.json</code>.
     * </p>
     * 
     * @param outputS3Uri
     *        The location of the Amazon S3 object where Amazon Augmented AI stores your human loop output. The output
     *        is stored at the following location: <code>s3://S3OutputPath/HumanLoopName/CreationTime/output.json</code>
     *        .
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public HumanLoopOutputContent withOutputS3Uri(String outputS3Uri) {
        setOutputS3Uri(outputS3Uri);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getOutputS3Uri() != null)
            sb.append("OutputS3Uri: ").append(getOutputS3Uri());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof HumanLoopOutputContent == false)
            return false;
        HumanLoopOutputContent other = (HumanLoopOutputContent) obj;
        if (other.getOutputS3Uri() == null ^ this.getOutputS3Uri() == null)
            return false;
        if (other.getOutputS3Uri() != null && other.getOutputS3Uri().equals(this.getOutputS3Uri()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getOutputS3Uri() == null) ? 0 : getOutputS3Uri().hashCode());
        return hashCode;
    }

    @Override
    public HumanLoopOutputContent clone() {
        try {
            return (HumanLoopOutputContent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        com.amazonaws.services.augmentedairuntime.model.transform.HumanLoopOutputContentMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
