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

package software.amazon.awssdk.services.s3;

import java.util.Map;
import software.amazon.awssdk.awscore.AwsResponseMetadata;

/**
 * Class javadoc
 */
public final class S3ResponseMetadata extends AwsResponseMetadata {

    public static final String HOST_ID = "HOST_ID";
    public static final String CLOUD_FRONT_ID = "CLOUD_FRONT_ID";

    public S3ResponseMetadata(Map<String, String> metadata) {
        super(metadata);
    }

    public S3ResponseMetadata(AwsResponseMetadata awsResponseMetadata) {
        this(awsResponseMetadata.metadata());
    }

    public static S3ResponseMetadata create(Map<String, String> metadata) {
        return new S3ResponseMetadata(metadata);
    }

    public String hostId() {
        return getValue(HOST_ID);
    }

    public String cloudFrontId() {
        return getValue(CLOUD_FRONT_ID);
    }
}
