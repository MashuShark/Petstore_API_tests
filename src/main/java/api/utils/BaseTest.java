package api.utils;

import api.steps.UserSteps;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Base {

    public UserSteps userSteps = new UserSteps();

    @BeforeMethod(alwaysRun = true, onlyForGroups = "createUser")
    public void createUserCondition() {
        userSteps.userCreate(user);
    }

    @BeforeMethod(alwaysRun = true, onlyForGroups = "deleteUser")
    public void deleteUserCondition() {
        userSteps.deleteUser(user.getUsername());
    }
}
