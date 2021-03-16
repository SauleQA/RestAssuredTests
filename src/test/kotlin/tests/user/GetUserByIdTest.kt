package tests.user

import controller.user.getUserById
import net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import org.apache.http.HttpStatus
import org.hamcrest.MatcherAssert.assertThat
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import tests.BaseTest

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GetUserByIdTest : BaseTest() {
    @Test
    fun test_01_GetUser_200OK() {
        val responseBody = getUserById("1")
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response()
            .asString()
        assertThat(
            responseBody,
            jsonEquals(resource("user/getFirstUser.json"))
        )
    }

    @Test
    fun test_02_GetNonExistentUser_404() {
        val responseBody = getUserById("4")
            .statusCode(HttpStatus.SC_NOT_FOUND)
            .extract()
            .response()
            .asString()
        assertThat(
            responseBody,
            jsonEquals(resource("user/getNonExistentUser.json"))
        )
    }
}