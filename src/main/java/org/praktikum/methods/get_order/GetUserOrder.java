package org.praktikum.methods.get_order;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.TestData;

import static io.restassured.RestAssured.given;

public class GetUserOrder extends TestData {
    @Step("Получение заказов пользователя")
    public Response getOrdersUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .baseUri(MY_URL)
                .get(ENDPOINT_CREATED_AND_GET_ORDER);
    }

}
