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

package software.amazon.awssdk.services.cloudwatch;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatch.model.ListDashboardsResponse;
import software.amazon.awssdk.testutils.service.AwsIntegrationTestBase;

/**
 * Integration tests for the AWS CloudWatch service.
 */
public class CloudWatchIntegrationTest1 extends AwsIntegrationTestBase {

    private static final int ONE_WEEK_IN_MILLISECONDS = 1000 * 60 * 60 * 24 * 7;
    private static final int ONE_HOUR_IN_MILLISECONDS = 1000 * 60 * 60;
    /** The CloudWatch client for all tests to use. */
    private static CloudWatchClient cloudwatch;

    /**
     * Loads the AWS account info for the integration tests and creates a
     * CloudWatch client for tests to use.
     */
    @BeforeClass
    public static void setUp() throws IOException {
        cloudwatch = CloudWatchClient.builder()
                                     .credentialsProvider(getCredentialsProvider())
                                     .region(Region.US_WEST_2)
                                     .build();
    }

    @Test
    public void test() {
        ListDashboardsResponse test = cloudwatch.listDashboards();
        System.out.println(test.sdkHttpResponse().headers());
    }
}
