package org.praktikum.test.data;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestData {
    protected final static String MY_URL = "https://stellarburgers.nomoreparties.site";
    protected final static String ENDPOINT_AUTHORIZATION_USER = "/api/auth/login";
    protected final static String ENDPOINT_NEW_USER = "/api/auth/register";
    protected final static String ENDPOINT_DELETE_UPDATE_GET_USER = "/api/auth/user";
    protected final static String ENDPOINT_CREATED_AND_GET_ORDER = "/api/orders";
    protected final static String ENDPOINT_GET_INGREDIENTS = "/api/ingredients";
    private final static Faker faker = new Faker();
    protected static String email = faker.name().firstName() + "@yandex.ru";
    protected static String password = faker.animal().name();
    protected static String name = faker.name().username();
    protected static String updateEmail = faker.name().username() + "@yandex.ru";
    protected static String updatePassword = faker.name().lastName();
    protected static String updateName = faker.name().firstName();
    protected static List<String> dontValidliIngredientsList = new ArrayList<>(Arrays.asList("sdfasf", "asdfasf"));
}
