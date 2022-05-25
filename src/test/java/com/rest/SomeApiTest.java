package com.rest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

class SomeApiTest {

    private static final String URL = "https://api.publicapis.org/entries";

    @Test
    void shouldReturnListOfEntries() {
        // given
        EntriesResponseDTO entriesResponseDTO =
                given().baseUri(URL)
                        .log()
                        .all()
                        .when()
                        .get()
                        .then()
                        .log()
                        .all()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .as(EntriesResponseDTO.class);

        // then
        assertThat(entriesResponseDTO).isNotNull();
        assertThat(entriesResponseDTO.count).isGreaterThan(0);
    }
}
