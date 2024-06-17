package com.myorg;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.Duration;
import software.amazon.awscdk.services.sqs.Queue;

public class NetworkCdkStack extends Stack {

    public NetworkCdkStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public NetworkCdkStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);
        System.out.println("Environment >>>>> " + props.getEnv());

        final Queue queue = Queue.Builder.create(this, "NetworkCdkQueue")
            .visibilityTimeout(Duration.seconds(300))
            .build();
    }
}
