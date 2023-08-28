package org.praktikum.update.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.CleareBase;
import org.praktikum.methods.authorization.AuthorizationUser;
import org.praktikum.methods.created.user.CreatedUser;
import org.praktikum.methods.update.user.UpdateUserData;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateAuthorizationUserTest extends CleareBase {
    UpdateUserData update = new UpdateUserData();
    CreatedUser createdUser = new CreatedUser();
    AuthorizationUser user = new AuthorizationUser();


    @Before
    public void createdAndAuthorizationUser() {
        createdUser.createdNewUser();
        user.authorizationValidliUserData();
        token = user.accessToken;
    }

    @Test
    @DisplayName("Обновление email")
    @Description("Обновление email авторизованного пользователя")
    public void updateEmailUserTest() {
        update.updateEmailUser(token)
                .then().assertThat().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Обновление password")
    @Description("Обновление password авторизованного пользователя")
    public void updatePasswordUserTest() {
        update.updatePasswordUser(token)
                .then().assertThat().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Обновление name")
    @Description("Обновление name авторизованного пользователя")
    public void updateNameUserTest() {
        update.updateNameUser(token)
                .then().assertThat().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Обновление всех данных")
    @Description("Обновление всех данных авторизованного пользователя")
    public void fullUpdateUserTest() {
        update.fullUpdateUser(token)
                .then().assertThat().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
    }

}
