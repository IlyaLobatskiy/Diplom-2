package org.praktikum.authorizations_tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.praktikum.methods.authorization.AuthorizationUser;

import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class AuthorizationNotValidliUserDataTest {
    private final String email;
    private final String password;
    AuthorizationUser user = new AuthorizationUser();

    public AuthorizationNotValidliUserDataTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getUserLoginData() {
        return new Object[][]{
                {"Test@test.ru", ""},
                {"", "UserPassword"},
        };
    }

    @Test
    @DisplayName("Авторизация пользователя с неполными данными")
    @Description("Авторизуем пользователя без логина или пароля")
    public void authorizationNotValidliUserDataTest() {
        user.authorizationNotValidliUserData(email, password)
                .then().assertThat().statusCode(SC_UNAUTHORIZED)
                .and()
                .body("message", equalTo("email or password are incorrect"));
    }
}
