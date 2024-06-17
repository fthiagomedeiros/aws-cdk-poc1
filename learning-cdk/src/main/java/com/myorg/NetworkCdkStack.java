package com.myorg;

import software.amazon.awscdk.services.ec2.IpAddresses;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class NetworkCdkStack extends Stack {

    public NetworkCdkStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        Vpc vpc = Vpc.Builder.create(this, "TheVPC - " + props.getStackName())
            .ipAddresses(IpAddresses.cidr("10.0.0.0/16"))
            .build();
    }


}
