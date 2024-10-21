package com.compassway.api.endpoints.emails;

import com.compassway.api.BaseApiClient;
import com.compassway.api.models.EmailBoxDto;
import com.compassway.api.models.EmailDto;
import com.compassway.utils.ConfigLoader;

public class EmailEndpoint extends BaseApiClient {

    private static final String EMAILS_ENDPOINT = "/emails";
    private static final String EMAIL_ENDPOINT = "/email";

    public EmailEndpoint(String baseUri) {
        super(baseUri);
        setBasicAuth(ConfigLoader.getCredentials("apiUsername"), ConfigLoader.getCredentials("apiPassword"));
    }

    public EmailBoxDto getEmails(int expectedStatusCode) {
        return get(EMAILS_ENDPOINT, EmailBoxDto.class, expectedStatusCode);
    }

    public EmailDto sendEmail(EmailDto emailRequest, int expectedStatusCode) {
        return post(EMAILS_ENDPOINT, emailRequest, EmailDto.class, expectedStatusCode);
    }

    public EmailDto getEmail(int emailId, int expectedStatusCode) {
        return get(String.format(EMAILS_ENDPOINT + "/%d", emailId), EmailDto.class, expectedStatusCode);
    }

    public void deleteEmail(int emailId, int expectedStatusCode) {
        delete(String.format(EMAIL_ENDPOINT + "/%d", emailId), expectedStatusCode);
    }
}
