package org.praktikum.get.orders;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.CleareBase;
import org.praktikum.methods.authorization.AuthorizationUser;
import org.praktikum.methods.created.order.CreatedOrder;
import org.praktikum.methods.created.user.CreatedUser;
import org.praktikum.methods.get.order.GetUserOrder;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetUserOrderTest extends CleareBase {

    GetUserOrder getUserOrder = new GetUserOrder();
    CreatedOrder order = new CreatedOrder();
    CreatedUser user = new CreatedUser();
    AuthorizationUser authorizationUser = new AuthorizationUser();

    @Before
    public void testUser() {
        user.createdNewUser();
        authorizationUser.authorizationValidliUserData();
        token = authorizationUser.accessToken;
        order.createdOrder(token);
    }

    @Test
    @DisplayName("Получение списка заказов конкретного пользователя")
    @Description("Получение списка заказов конкретного авторизованного пользователя")
    public void getAuthorizationUserOrdersTest() {
        getUserOrder.getOrdersUser(token)
                .then().assertThat().statusCode(SC_OK)
                .and()
                .body("orders", notNullValue());
    }

    @Test
    @DisplayName("Получение списка заказов конкретного не авторизованного пользователя")
    @Description("Получение списка заказов конкретного не авторизованного пользователя")
    public void getDontAuthorizationUserOrdersTest() {
        getUserOrder.getOrdersUser("")
                .then().assertThat().statusCode(SC_UNAUTHORIZED)
                .and()
                .body("message", equalTo("You should be authorised"));
    }
}
