package tests.task

import controller.task.addNewTasks
import helpers.taskController.AddBlockedUserHelper
import helpers.taskController.AddNewCorrectTaskHelper
import helpers.taskController.AddNewNonExistentUserHelper
import net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import net.javacrumbs.jsonunit.core.util.ResourceUtils.resource
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import stub.UserBlockStub.stubForIsUserBlock
import tests.BaseTest

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AddNewTaskTest : BaseTest() {
    @Before
    fun before() {
        stubForIsUserBlock()
    }
        @Test
    fun test_01_AddNewTask_200OK() {
        val responseBody = addNewTasks(AddNewCorrectTaskHelper().requestBody)
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response()
            .asString()
        assertThat(
            responseBody, equalTo(AddNewCorrectTaskHelper().requestBody["name"])
        )
    }

    @Test
    fun test_02_UserIsNotFound_404() {
        val responseBody = addNewTasks(AddNewNonExistentUserHelper().requestBody)
            .statusCode(HttpStatus.SC_NOT_FOUND)
            .extract()
            .response()
            .asString()
        assertThat(
            responseBody,
            jsonEquals(resource("task/UserIsNotFound.json"))
        )
    }

    @Test
    fun test_03_UserIsBlocked_400() {
        val responseBody = addNewTasks(AddBlockedUserHelper().requestBody)
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract()
            .response()
            .asString()
        assertThat(
            responseBody,
            jsonEquals(resource("task/UserIsBlocked.json"))
        )
    }
}