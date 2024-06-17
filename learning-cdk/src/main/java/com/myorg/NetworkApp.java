package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.StackProps;

public class NetworkApp {

    public static void main(final String[] args) {
        App app = new App();

        String environment = (String) app.getNode().tryGetContext("env");
        requireNonEmpty(environment, "context variable 'env' must not be null");

        String region = (String) app.getNode().tryGetContext("region");
        requireNonEmpty(region, "context variable 'region' must not be null");

        String accountId = (String) app.getNode().tryGetContext("accountId");
        requireNonEmpty(accountId, "context variable 'accountId' must not be null");

        new NetworkCdkStack(app,
            "NetworkAppStack",
            StackProps.builder()
                .stackName("network-" + environment)
                .build());

        app.synth();
    }

    public static void requireNonEmpty(String string, String message) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}

