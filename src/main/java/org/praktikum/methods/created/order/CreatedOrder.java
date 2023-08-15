package org.praktikum.methods.created.order;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.TestData;
import org.praktikum.serialization.OrderData;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreatedOrder extends TestData {
    @Step
    public Response createdOrder(String accessToken) {
        OrderData json = new OrderData(ingredientsList);

        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_CREATED_AND_GET_ORDER);
    }

    @Step
    public Response createdOrderEmptyIngredientsList(String accessToken) {
        OrderData json = new OrderData(new ArrayList<>());

        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_CREATED_AND_GET_ORDER);
    }

    @Step
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
