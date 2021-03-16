package helpers

object Instance {

    val APP_URL: String? = System.getenv("APP_URL")

    fun getAppUrl(): String {
        return APP_URL ?: "http://localhost:8080"
    }

    val app_url = getAppUrl()
}