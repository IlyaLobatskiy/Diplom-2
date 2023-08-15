package org.praktikum.created_test.order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.CleareBase;
import org.praktikum.methods.created.order.CreatedOrder;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreatedOrderDontAuthoriztionUserTest extends CleareBase {
    CreatedOrder order = new CreatedOrder();

    @Before
    public void tokenForUpdate() {
        token = "";
    }

    @Test
    @DisplayName("Создание заказа")
    @Description("Создание заказа с ингридиентами не авторизованным пользователем")
    public void createdValidliOrder() {
        order.createdOrder(token)
                .then().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Создание заказа без ингридиентов")
    @Description("Создание заказа без ингридиентами не авторизованным пользователем")
    public void createdDontValidliOrder() {
        order.createdOrderEmptyIngredientsList(token)
                .then().statusCode(SC_BAD_REQUEST)
                .and()
                .body("message", equalTo("Ingredient ids must be provided"));
    }
    @Test
    @DisplayName("Создание заказа c невалидным списком ингридиентов")
    @Description("Создание заказа c невалидным списком ингридиентами не авторизованным пользователем")
    public void createdDontValidliIngredientsListTest() {
        order.createdOrderDontValidliIngredientsList(token)
                .then().statusCode(SC_INTERNAL_SERVER_ERROR);
    }
}
