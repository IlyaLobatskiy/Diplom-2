package org.praktikum.methods.get.order;

import io.restassured.response.Response;
import org.praktikum.deserialization.order.Data;
import org.praktikum.deserialization.order.Ingredients;
import org.praktikum.test.data.TestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class GetIngredients extends TestData {

    public List<String> ingredientsList = new ArrayList<>();
    Random random = new Random();

    public List<String> getIdIngredients() {
        Response response = given()
                .baseUri(MY_URL)
                .get(ENDPOINT_GET_INGREDIENTS);
        List<Data> list = response.body().as(Ingredients.class).getData();
        for (int i = 0; i < 4; i++) {
            ingredientsList.add(list.get(random.nextInt(list.size() - 1)).get_id());
        }
        return ingredientsList;
    }
}
