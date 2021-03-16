package controller.task

import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse

fun getAllTasks()
        : ValidatableResponse {
    return given(taskSpec()).
        `when`()
            .get().
        then()
}
