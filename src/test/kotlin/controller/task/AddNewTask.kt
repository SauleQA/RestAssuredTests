package controller.task

import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse

fun addNewTasks(requestPayload: Map<String, Any>)
        : ValidatableResponse {
    return given(taskSpec())
            .body(requestPayload).
        `when`()
            .post().
        then()
}