package org.praktikum.created_test.user;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.praktikum.methods.created.user.CreatedUser;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class CrearedUserIncompleteDataTest {

    private final String email;
    private final String password;
    private final String name;
    CreatedUser user = new CreatedUser();

    public CrearedUserIncompleteDataTest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Test@test.ru", "UserPassword", ""},
                {"Test@test.ru", "", "Test"},
                {"", "UserPassword", "Test"},
        };
    }
    @Test
    @DisplayName("Создание пользователя с неполными данными")
    @Description("Создаем пользователя незаполнив обязательные поля")
    public void creatingUserDontRequiredFieldsTest() {
        user.creatingUserDontRequiredFields(email, password, name)
                .then().assertThat().statusCode(SC_FORBIDDEN)
                .and()
                .body("message", equalTo("Email, password and name are required fields"));
    }
}
