package org.praktikum.authorizations_tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.CleareBase;
import org.praktikum.methods.authorization.AuthorizationUser;
import org.praktikum.methods.created.user.CreatedUser;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class AuthorizationUserTest extends CleareBase {
    AuthorizationUser authorizationUser = new AuthorizationUser();
    @Before
    public void createdUser() {
        CreatedUser createdUser = new CreatedUser();
        createdUser.createdNewUser();
    }

    @Test
    @DisplayName("Авторизация пользователя")
    @Description("Авторизация пользователя с валидными данными")
    public void createdNewUserTest() {
        authorizationUser.authorizationValidliUserData()
                .then().assertThat().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
        token = authorizationUser.accessToken;
    }

}
