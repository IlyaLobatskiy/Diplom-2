package org.praktikum;

import org.junit.After;
import org.praktikum.methods.delete.user.DeleteUser;

public class CleareBase {
    protected String token;
    DeleteUser delete = new DeleteUser();
    @After
    public void deleteUser() {
        delete.deleteUser(token);
    }
}
