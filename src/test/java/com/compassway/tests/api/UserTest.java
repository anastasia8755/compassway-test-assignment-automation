package com.compassway.tests.api;

import com.compassway.api.endpoints.emails.EmailsApi;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void UserTest1(){
        EmailsApi.emailsApi().user().getCurrentUser(200);
    }
}
