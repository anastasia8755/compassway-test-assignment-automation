package com.compassway.api.endpoints.emails;

import com.compassway.api.BaseApiClient;
import com.compassway.api.models.UserDto;
import com.compassway.utils.ConfigLoader;

public class UserEndpoint extends BaseApiClient {

    private static final String USERS_ENDPOINT = "/users";
    private static final String USERS_CURRENT_ENDPOINT = USERS_ENDPOINT + "/current";

    public UserEndpoint(String baseUri) {
        super(baseUri);
        setBasicAuth(ConfigLoader.getCredentials("apiUsername"), ConfigLoader.getCredentials("apiPassword"));
    }

    public UserDto createUser(UserDto userRequest, int expectedStatusCode) {
        return post(USERS_ENDPOINT, userRequest, UserDto.class, expectedStatusCode);
    }

    public UserDto getCurrentUser(int expectedStatusCode) {
        return get(USERS_CURRENT_ENDPOINT, UserDto.class, expectedStatusCode);
    }
}
