package org.praktikum.update.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.CleareBase;
import org.praktikum.methods.update.user.UpdateUserData;

import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateDontAuthorizationUserTest extends CleareBase {
    UpdateUserData update = new UpdateUserData();


    @Before
    public void tokenForUpdate() {
        token = "";
    }

    @Test
    @DisplayName("Обновление email")
    @Description("Обновление email авторизованного пользователя")
    public void updateEmailUserTest() {
        update.updateEmailUser(token)
                .then().assertThat().statusCode(SC_UNAUTHORIZED)
                .and()
                .body("message", equalTo("You should be authorised"));
    }

    @Test
    @DisplayName("Обновление password")
    @Description("Обновление password авторизованного пользователя")
    public void updatePasswordUserTest() {
        update.updatePasswordUser(token)
                .then().assertThat().statusCode(SC_UNAUTHORIZED)
                .and()
                .body("message", equalTo("You should be authorised"));
    }

    @Test
    @DisplayName("Обновление name")
    @Description("Обновление name авторизованного пользователя")
    public void updateNameUserTest() {
        update.updateNameUser(token)
                .then().assertThat().statusCode(SC_UNAUTHORIZED)
                .and()
                .body("message", equalTo("You should be authorised"));
    }

    @Test
    @DisplayName("Обновление всех данных")
    @Description("Обновление всех данных авторизованного пользователя")
    public void fullUpdateUserTest() {
        update.fullUpdateUser(token)
                .then().assertThat().statusCode(SC_UNAUTHORIZED)
                .and()
                .body("message", equalTo("You should be authorised"));
    }
}
