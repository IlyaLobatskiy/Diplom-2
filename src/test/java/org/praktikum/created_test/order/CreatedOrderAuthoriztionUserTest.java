package org.praktikum.created_test.order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.CleareBase;
import org.praktikum.methods.authorization.AuthorizationUser;
import org.praktikum.methods.created.order.CreatedOrder;
import org.praktikum.methods.created.user.CreatedUser;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreatedOrderAuthoriztionUserTest extends CleareBase {
    CreatedOrder order = new CreatedOrder();
    CreatedUser user = new CreatedUser();
    AuthorizationUser authorizationUser = new AuthorizationUser();

    @Before
    public void testUser() {
        user.createdNewUser();
        authorizationUser.authorizationValidliUserData();
        token = authorizationUser.accessToken;
    }
    @Test
    @DisplayName("Создание заказа")
    @Description("Создание заказа с ингридиентами авторизованным пользователем")
    public void createdValidliOrderTest() {
        order.createdOrder(token)
                .then().statusCode(SC_OK)
                .and()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Создание заказа без ингридиентов")
    @Description("Создание заказа без ингридиентами авторизованным пользователем")
    public void createdDontValidliOrderTest() {
        order.createdOrderEmptyIngredientsList(token)
                .then().statusCode(SC_BAD_REQUEST)
                .and()
                .body("message", equalTo("Ingredient ids must be provided"));
    }

    @Test
    @DisplayName("Создание заказа c невалидным списком ингридиентов")
    @Description("Создание заказа c невалидным списком ингридиентами авторизованным пользователем")
    public void createdDontValidliIngredientsListTest() {
        order.createdOrderDontValidliIngredientsList(token)
                .then().statusCode(SC_INTERNAL_SERVER_ERROR);
    }

}
