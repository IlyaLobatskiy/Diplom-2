package org.praktikum.methods.created.order;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.methods.get.order.GetIngredients;
import org.praktikum.serialization.OrderData;
import org.praktikum.test.data.TestData;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreatedOrder extends TestData {
    GetIngredients getIngredients = new GetIngredients();

    @Step("Создание заказа")
    public Response createdOrder(String accessToken) {
        OrderData json = new OrderData(getIngredients.getIdIngredients());

        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_CREATED_AND_GET_ORDER);
    }

    @Step("Создание заказа с пустым списком ингридиентов")
    public Response createdOrderEmptyIngredientsList(String accessToken) {
        OrderData json = new OrderData(new ArrayList<>());

        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_CREATED_AND_GET_ORDER);
    }

    @Step("Создание заказа с невалидными ингредиентами")
    public Response createdOrderDontValidliIngredientsList(String accessToken) {
        OrderData json = new OrderData(dontValidliIngredientsList);

        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_CREATED_AND_GET_ORDER);
    }


}
