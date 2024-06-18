package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.s3.CfnBucket;
import software.constructs.Construct;

public class BucketStack extends Stack {

    public BucketStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        CfnBucket bucket = new CfnBucket(this, "my-custom-bucket-fthiagom");
    }


}
