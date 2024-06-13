package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.StackProps;

public class MyCustomCdkApp {

    public static void main(final String[] args) {
        App app = new App();

        new MyCustomCdkStack(app, "MyCustomCdkStack", StackProps.builder()
            .build());

        new MySecondCdkStack(app, "MySecondCdkStack", StackProps.builder()
            .build());

        app.synth();
    }
}

