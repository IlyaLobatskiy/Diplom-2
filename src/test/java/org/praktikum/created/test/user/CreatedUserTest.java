package org.praktikum.created.test.user;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.praktikum.CleareBase;
import org.praktikum.methods.created.user.CreatedUser;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreatedUserTest extends CleareBase {
    CreatedUser createdUser = new CreatedUser();

    @Test
    @DisplayName("Создание пользователя")
    @Description("Создаем пользователя с валидными данными")
    public void createdNewUserTest() {
        createdUser.createdNewUser()
                .then().assertThat().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
        token = createdUser.accessToken;
    }

    @Test
    @DisplayName("Создание зарегистрированного пользователя")
    @Description("Создаем пользователя ранее зарегистрированного в системе")
    public void createdRegisteredUserTest() {
        createdUser.createdNewUser();
        token = createdUser.accessToken;
        createdUser.createdNewUser()
                .then().assertThat().statusCode(SC_FORBIDDEN)
                .and()
                .body("message", equalTo("User already exists"));

    }
}
