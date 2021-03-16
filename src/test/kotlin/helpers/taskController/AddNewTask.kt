package helpers.taskController

class AddNewCorrectTaskHelper {
    val requestBody = mapOf(
        "assigneeId" to 1 ,
        "authorId" to 2 ,
        "description" to "Задача для тестирования API" ,
        "name" to "Тестовый тикет"
    )
}

class AddNewNonExistentUserHelper {
    val requestBody = mapOf(
        "assigneeId" to 1 ,
        "authorId" to 4 ,
        "description" to "Задача для тестирования API" ,
        "name" to "Тестовый тикет"
    )
}

class AddBlockedUserHelper {
    val requestBody = mapOf(
        "assigneeId" to 1 ,
        "authorId" to 1 ,
        "description" to "Задача для тестирования API" ,
        "name" to "Тестовый тикет"
    )
}
