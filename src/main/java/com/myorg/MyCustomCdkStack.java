package com.myorg;

import software.amazon.awscdk.services.s3.Bucket;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class MyCustomCdkStack extends Stack {

    public MyCustomCdkStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public MyCustomCdkStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here
        Bucket.Builder.create(this, "my-custom-cdk-bucket")
            .versioned(true)
            .build();
    }
}
