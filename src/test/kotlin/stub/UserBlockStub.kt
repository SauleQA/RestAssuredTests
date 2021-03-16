package stub

import com.github.tomakehurst.wiremock.client.WireMock.*

object UserBlockStub {
    fun stubForIsUserBlock() {
        stubFor(
            get(urlEqualTo("/1"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withBody(
                            """true"""
                        )
                )
        )

        stubFor(
            get(urlEqualTo("/2"))
                .willReturn(
                    aResponse()
                        .withStatus(200)
                        .withBody(
                            """false"""
                        )
                )
        )

        stubFor(
            get(urlEqualTo("/4"))
                .willReturn(
                    aResponse()
                        .withStatus(404)
                        .withBody(
                            """{
                                        "message": "User is not found",
                                        "details": "User with id 3 does not exist"
                                 }"""
                        )
                )
        )
    }
}