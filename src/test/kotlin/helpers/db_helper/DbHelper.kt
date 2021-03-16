package helpers.db_helper

import helpers.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DbHelper {

    @Throws(SQLException::class)
    fun connect(): Connection {

        return DriverManager.getConnection(
                "jdbc:postgresql://$POSTGRES_URL:$POSTGRES_PORT/$POSTGRES_DB",
                POSTGRES_USER,
                POSTGRES_PASSWORD
        )
    }

    @Throws(SQLException::class)
    fun connectSQL(SQL: String) {
        val connect = connect()
        val statement = connect.createStatement()
        statement.execute(SQL)
        statement.close()
        connect.close()
    }

    @Throws(SQLException::class)
    fun removeDataFromTable(TABLE_NAME: String) {
        connectSQL("TRUNCATE TABLE $TABLE_NAME CASCADE")
    }

    @Throws(SQLException::class)
    fun createUser(id: Int, name: String) {
        val connect = connect()
        val statement = connect.createStatement()
        statement.addBatch("""INSERT INTO "users" VALUES ($id, '$name')""")
        statement.executeBatch()
        statement.close()
        connect.close()
    }
}