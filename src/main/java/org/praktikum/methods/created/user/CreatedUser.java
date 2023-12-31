package org.praktikum.methods.created.user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.deserialization.user.ResponseBodyRegAndLogin;
import org.praktikum.serialization.UserData;
import org.praktikum.test.data.TestData;

import static io.restassured.RestAssured.given;

public class CreatedUser extends TestData {
    public String accessToken;

    @Step("Создать пользователя")
    public Response createdNewUser() {
        UserData json = new UserData(email, password, name);
        Response user = given()
                .header("Content-type", "application/json")
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_NEW_USER);

        /*Исключение необходимо для корректной работы теста регистрации ужезарегистрированного пользователя.
         * Если пользователь не зарегистрирован, токен не приходит. Получается, что мы пытаемся сохранить в переменную
         * поле которого нет. Тест падает.*/
        try {
            accessToken = user.body().as(ResponseBodyRegAndLogin.class).getAccessToken();
        } catch (RuntimeException exception) {
            System.out.println("Пользователь уже зарегистрирован");
        }
        return user;
    }

    @Step("Создать пользователя с неполными данными")
    public Response creatingUserDontRequiredFields(String email, String password, String userName) {
        UserData json = new UserData(email, password, userName);
        return given()
                .header("Content-type", "application/json")
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_NEW_USER);
    }
}
