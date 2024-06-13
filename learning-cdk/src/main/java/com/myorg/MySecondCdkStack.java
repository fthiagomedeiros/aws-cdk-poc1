package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.sqs.Queue;
import software.constructs.Construct;

public class MySecondCdkStack extends Stack {

    public MySecondCdkStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public MySecondCdkStack(Construct scope, String id, StackProps props) {
        super(scope, id, props);

        Queue.Builder.create(this, "my-custom-cdk-queue-1").build();
        Queue.Builder.create(this, "my-custom-cdk-queue-2").build();

    }
}
