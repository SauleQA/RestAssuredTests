package tests

import com.github.tomakehurst.wiremock.junit.WireMockRule
import helpers.db_helper.DbHelper.createUser
import helpers.db_helper.DbHelper.removeDataFromTable
import org.junit.Before
import org.junit.Rule

abstract class BaseTest {

    @get:Rule
    var wireMockRule = WireMockRule(8044)

    @Before
    fun creatUsers() {
        removeDataFromTable("users")
        removeDataFromTable("tasks")
        createUser(1, "First User")
        createUser(2, "Second User")
        createUser(3, "Third User")
    }
}