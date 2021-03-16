package controller.task

import helpers.Instance.app_url
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification

fun taskSpec(): RequestSpecification? {
    return RequestSpecBuilder()
        .setBaseUri(app_url)
        .setContentType(ContentType.JSON)
        .setBasePath("/v1/tasks")
        .addFilter(RequestLoggingFilter())
        .addFilter(ResponseLoggingFilter())
        .build()
}