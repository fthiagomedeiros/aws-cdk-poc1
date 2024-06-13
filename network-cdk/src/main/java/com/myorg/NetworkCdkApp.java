package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class NetworkCdkApp {

    public static void main(final String[] args) {
        App app = new App();

        String environmentName = (String) app.getNode().tryGetContext("environmentName");
        requireNonEmpty(environmentName, "context variable 'environmentName' must not be null");

        String accountId = (String) app.getNode().tryGetContext("accountId");
        requireNonEmpty(accountId, "context variable 'accountId' must not be null");

        String region = (String) app.getNode().tryGetContext("region");
        requireNonEmpty(region, "context variable 'region' must not be null");

        Environment awsEnvironment = makeEnv(accountId, region);

        new NetworkCdkStack(app, "NetworkCdkStack", StackProps.builder()
            .stackName("Network-" + environmentName)
            .env(awsEnvironment)
            .build());

        app.synth();
    }

    static Environment makeEnv(String account, String region) {
        return Environment.builder()
            .account(account)
            .region(region)
            .build();
    }

    public static void requireNonEmpty(String value, String message) {
        System.out.println(value);
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}

