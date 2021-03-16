package tests.user

import controller.user.getAllUsers
import helpers.db_helper.DbHelper.removeDataFromTable
import net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import org.apache.http.HttpStatus
import org.hamcrest.MatcherAssert.assertThat
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import tests.BaseTest

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GetAllUsersTest : BaseTest() {

    @Test
    fun test_01_GetAllUsers_200OK() {
        val responseBody = getAllUsers()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response()
            .asString()
        assertThat(
            responseBody,
            jsonEquals(resource("user/getAllUsers.json"))
        )
    }

    @Test
    fun test_02_GetAllUsers_NoUsers_200OK() {
        removeDataFromTable("users")
        val responseBody = getAllUsers()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response()
            .asString()
        assertThat(
            responseBody,
            jsonEquals("""[]""")
        )
    }
}