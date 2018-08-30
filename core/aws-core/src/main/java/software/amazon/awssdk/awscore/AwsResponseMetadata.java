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

package software.amazon.awssdk.awscore;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import software.amazon.awssdk.annotations.Immutable;
import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.utils.ToString;

/**
 * Represents additional metadata included with a response from a service. Response
 * metadata varies by service, but all services return an AWS request ID that
 * can be used in the event a service call isn't working as expected and you
 * need to work with AWS support to debug an issue.
 * <p>
 * Access to AWS request IDs is also available through the com.amazonaws.request
 * logger in the AWS SDK for Java.
 */
@Immutable
@SdkPublicApi
public class AwsResponseMetadata {
    public static final String AWS_REQUEST_ID = "AWS_REQUEST_ID";
    private static final String UNKNOWN = "UNKNOWN";

    private final Map<String, String> metadata;

    /**
     * Creates a new ResponseMetadata object from a specified map of raw
     * metadata information.
     *
     * @param metadata
     *            The raw metadata for the new ResponseMetadata object.
     */
    public AwsResponseMetadata(Map<String, String> metadata) {
        this.metadata = Collections.unmodifiableMap(metadata);
    }

    /**
     * Creates a new ResponseMetadata object from an existing ResponseMetadata
     * object.
     *
     * @param originalResponseMetadata
     *            The ResponseMetadata object from which to create the new
     *            object.
     */
    public AwsResponseMetadata(AwsResponseMetadata originalResponseMetadata) {
        this(originalResponseMetadata.metadata);
    }

    /**
     * Returns the AWS request ID contained in this response metadata object.
     * AWS request IDs can be used in the event a service call isn't working as
     * expected and you need to work with AWS support to debug an issue.
     *
     * @return The AWS request ID contained in this response metadata object.
     */
    public final String requestId() {
        return getValue(AWS_REQUEST_ID);
    }

    public final String metadata(String key) {
        return getValue(key);
    }

    public final Map<String, String> metadata() {
        return metadata;
    }

    protected final String getValue(String key) {
        return Optional.ofNullable(metadata.get(key)).orElse(UNKNOWN);
    }

    @Override
    public String toString() {
        return ToString.builder("AwsResponseMetadata")
                       .add("metadata", metadata.keySet())
                       .build();
    }
}
