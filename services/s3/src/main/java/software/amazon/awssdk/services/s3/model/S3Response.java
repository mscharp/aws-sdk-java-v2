/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.services.s3.model;

import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.awscore.AwsResponse;
import software.amazon.awssdk.awscore.AwsResponseMetadata;
import software.amazon.awssdk.services.s3.S3ResponseMetadata;

@Generated("software.amazon.awssdk:codegen")
public abstract class S3Response extends AwsResponse {
    private final S3ResponseMetadata s3ResponseMetadata;

    protected S3Response(Builder builder) {
        super(builder);
        this.s3ResponseMetadata = builder.responseMetadata();
    }

    @Override
    public S3ResponseMetadata responseMetadata() {
        return s3ResponseMetadata;
    }

    public interface Builder extends AwsResponse.Builder {

        S3ResponseMetadata responseMetadata();

        Builder responseMetadata(AwsResponseMetadata s3ResponseMetadata);

        @Override
        S3Response build();
    }

    protected abstract static class BuilderImpl extends AwsResponse.BuilderImpl implements Builder {
        private S3ResponseMetadata s3ResponseMetadata;

        protected BuilderImpl() {
        }

        protected BuilderImpl(S3Response response) {
            super(response);
            this.s3ResponseMetadata = response.responseMetadata();
        }

        @Override
        public Builder responseMetadata(AwsResponseMetadata responseMetadata) {
            this.s3ResponseMetadata = new S3ResponseMetadata(responseMetadata);
            return this;
        }

        @Override
        public S3ResponseMetadata responseMetadata() {
            return s3ResponseMetadata;
        }
    }
}
