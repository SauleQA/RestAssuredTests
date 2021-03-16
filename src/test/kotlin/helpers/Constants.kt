package helpers

val POSTGRES_URL = System.getenv("POSTGRES_URL") ?: "localhost"
val POSTGRES_PORT = System.getenv("POSTGRES_PORT") ?: "5432"
val POSTGRES_DB = System.getenv("POSTGRES_DB") ?: "testtask"
val POSTGRES_USER = System.getenv("POSTGRES_USER") ?: "postgres"
val POSTGRES_PASSWORD = System.getenv("POSTGRES_USER") ?: "postgres"

