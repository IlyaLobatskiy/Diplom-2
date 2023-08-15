package org.praktikum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestData {
    protected final static String MY_URL = "https://stellarburgers.nomoreparties.site";
    protected final static String ENDPOINT_AUTHORIZATION_USER = "/api/auth/login";
    protected final static String ENDPOINT_NEW_USER = "/api/auth/register";
    protected final static String ENDPOINT_DELETE_UPDATE_GET_USER = "/api/auth/user";
    protected final static String ENDPOINT_CREATED_AND_GET_ORDER = "/api/orders";

    protected static String email = "ilyalobackiy@yandex.ru";
    protected static String password = "Qwerty54321";
    protected static String name = "ilyalobackiy";
    protected static String updateEmail = "TestTestov@yandex.ru";
    protected static String updatePassword = "Qwerty";
    protected static String updateName = "Test";
    protected static List<String> ingredientsList = new ArrayList<>(Arrays.asList("61c0c5a71d1f82001bdaaa6d", "61c0c5a71d1f82001bdaaa70", "61c0c5a71d1f82001bdaaa74", "61c0c5a71d1f82001bdaaa6d"));
    protected static List<String> dontValidliIngredientsList = new ArrayList<>(Arrays.asList("sdfasf", "asdfasf"));
}
