package com.functional.db;

import static com.functional.steps.Order.toOrders;

import com.functional.steps.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final JdbcTemplate applicationJdbcTemplate;

    public OrderRepository(
            @Qualifier("applicationJdbcTemplate") JdbcTemplate applicationJdbcTemplate) {
        this.applicationJdbcTemplate = applicationJdbcTemplate;
    }

    public List<Order> loadAll() {
        return applicationJdbcTemplate.query(
                "select * from orders;", (resultSet, i) -> toOrders(resultSet));
    }
}
