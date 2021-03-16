package controller.user

import helpers.Instance.app_url
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.response.ValidatableResponse

fun getUserById(id: String)
        : ValidatableResponse {
    return given()
            .contentType(ContentType.JSON).
        `when`()
            .get("$app_url/v1/users/$id").
        then()
}
