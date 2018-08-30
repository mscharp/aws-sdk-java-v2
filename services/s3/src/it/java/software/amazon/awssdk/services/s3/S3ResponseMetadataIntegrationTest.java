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

import static org.assertj.core.api.Assertions.assertThat;
import static software.amazon.awssdk.testutils.service.S3BucketUtils.temporaryBucketName;

import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import software.amazon.awssdk.services.s3.model.GetObjectAclResponse;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.testutils.RandomTempFile;

/**
 * Class javadoc
 */
public class S3ResponseMetadataIntegrationTest extends S3IntegrationTestBase {

    private static final String BUCKET = temporaryBucketName(S3ResponseMetadataIntegrationTest.class);

    private static final String KEY = "some-key";

    private final GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                                                                      .bucket(BUCKET)
                                                                      .key(KEY)
                                                                      .build();

    private static File file;

    @BeforeClass
    public static void setupFixture() throws IOException {
        createBucket(BUCKET);
        file = new RandomTempFile(10_000);
        s3.putObject(PutObjectRequest.builder()
                                     .bucket(BUCKET)
                                     .key(KEY)
                                     .build(), file.toPath());
    }

    @AfterClass
    public static void deleteAllBuckets() {
        deleteBucketAndAllContents(BUCKET);
        file.delete();
    }

    @Test
    public void syncNonStreaming_shouldContainResponseMetadata() {
        GetObjectAclResponse response = s3.getObjectAcl(b -> b.key(KEY).bucket(BUCKET));
        S3ResponseMetadata s3ResponseMetadata = response.responseMetadata();
        assertThat(s3ResponseMetadata).isNotNull();
        assertThat(s3ResponseMetadata.requestId()).isNotEqualTo("UNKNOWN");
        assertThat(s3ResponseMetadata.hostId()).isNotEqualTo("UNKNOWN");
    }
}
