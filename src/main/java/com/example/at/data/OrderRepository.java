package com.example.at.data;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final JdbcTemplate applicationJdbcTemplate;

    public OrderRepository(final JdbcTemplate applicationJdbcTemplate) {
        this.applicationJdbcTemplate = applicationJdbcTemplate;
    }

    public List<OrderEntity> loadAll() {
        return applicationJdbcTemplate.query("select * from orders;", new OrderEntityMapper());
    }
}
