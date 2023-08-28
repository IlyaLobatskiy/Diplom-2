package org.praktikum.methods.delete.user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.test.data.TestData;

import static io.restassured.RestAssured.given;

public class DeleteUser extends TestData {

    @Step("Удаление пользователя")
    public Response deleteUser(String token) {
        return given()
                .header("Authorization", token)
                .baseUri(MY_URL)
                .delete(ENDPOINT_DELETE_UPDATE_GET_USER);
    }
}
