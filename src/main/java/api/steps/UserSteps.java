package api.steps;

import api.builders.CreateUser;
import api.objects.User;
import api.utils.BuilderUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.HashMap;

import static api.endpoints.Endpoints.*;
import static api.utils.ApiServices.*;
import static properties.TestData.USER_NAME_PATH;

public class UserSteps {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final BuilderUtil builderUtil = new BuilderUtil();

    @SneakyThrows
    @Step("Create user")
    public Response userCreate(User user) {
        CreateUser createUser = builderUtil.buildCreateUser(user.getId(), user.getUsername(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getPassword(), user.getPhone(), user.getUserStatus());
        return postRequest(CREATE_USER, null, createUser, null, null);
    }

    @SneakyThrows
    @Step("Get user")
    public Response getUser(String username) {
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put(USER_NAME_PATH, username);

        return getRequest(USER_BY_USERNAME, null, null, null, pathParams);
    }

    @SneakyThrows
    @Step("Get user")
    public Response deleteUser(String username) {
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put(USER_NAME_PATH, username);

        return deleteRequest(USER_BY_USERNAME, null, null, null, pathParams);
    }
}
