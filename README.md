# RestAssured - Kotlin API tests using wiremock
____
- Kotlin
- RestAssured
- Gradle
- JUnit
- Wiremock
____

RESTAssured API tests example using Kotlin.<br/>
#### The app under test is [SpringTaskProject](https://github.com/SauleQA/SpringTaskProject)<br/>

## Instructions to use
1. Clone and run projects [SpringTaskProject](https://github.com/SauleQA/SpringTaskProject) and [UserBlockApi](https://github.com/SauleQA/SpringUserBlockApi)
2. Clone this repo
3. There are 2 options:<br/>
  3.1 Run without wiremock
  - ./gradlew test --info
  3.2 Run with wiremock<br/>
  - open application.properties of SpringTaskProject
  - edit ```spring.datasource.url=jdbc:postgresql://127.0.0.1:8080```
  - ./gradlew test --info

# Author
[Saule Tussupbekova](https://www.linkedin.com/in/saule-tussupbekova/)
