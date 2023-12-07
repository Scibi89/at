package com.functional.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.at.data.OrderRepository;
import io.cucumber.java.en.Then;

public class DatabaseSteps {

    private final OrderRepository orderRepository;

    public DatabaseSteps(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Then("Orders are selectable")
    public void ordersAreSelectable() {
        assertThat(orderRepository.loadAll()).isNotEmpty();
    }
}
