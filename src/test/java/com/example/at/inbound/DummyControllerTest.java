package com.example.at.inbound;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWebMvc
@AutoConfigureMockMvc
class DummyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    DummyController dummyController;

    @Test
    void shouldReturnDummyId(){
        // when
        SomeObjectResponseDto response = dummyController.getSomeObject();

        // then
        assertThat(response.id()).isNotNull();
    }

}