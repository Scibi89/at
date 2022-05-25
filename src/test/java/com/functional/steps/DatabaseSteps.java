package com.functional.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.functional.db.OrderRepository;
import io.cucumber.java.en.Given;

public class DatabaseSteps {

    private final OrderRepository orderRepository;

    public DatabaseSteps(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Given("Orders are selectable")
    public void customerIsOnMainPage() {
        assertThat(orderRepository.loadAll()).isNotEmpty();
    }
}
