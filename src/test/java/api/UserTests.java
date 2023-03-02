package api;

import api.steps.UserSteps;
import api.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.utils.AssertsUtil.*;
import static io.restassured.RestAssured.given;
import static properties.TestData.GET_USER_JSON;


public class UserTests extends BaseTest {

    private final UserSteps userSteps = new UserSteps();

    @Test(groups = {"deleteUser"})
    public void createUser() {
        assertStatusCode(userSteps.userCreate(user), 200);
    }

    @Test(groups = {"createUser"})
    public void getUser() {
        assertCodeAndJson(userSteps.getUser(user.getUsername()), GET_USER_JSON, 200);
    }

    @Test(groups = {"createUser"})
    public void deleteUser() {
        assertStatusCode(userSteps.deleteUser(user.getUsername()), 200);
    }
}
