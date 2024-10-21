package com.compassway.api.endpoints.emails;

import com.compassway.utils.ConfigLoader;

public class EmailsApi {

    private final String baseUrl;

    public EmailsApi() {
        this.baseUrl = ConfigLoader.getProperty("apiBaseUrl");
    }

    public static EmailsApi emailsApi() {
        return new EmailsApi();
    }

    public EmailEndpoint email() {
        return new EmailEndpoint(baseUrl);
    }

    public UserEndpoint user() {
        return new UserEndpoint(baseUrl);
    }
}

