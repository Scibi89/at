package com.example.at.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class OrderEntityMapper implements RowMapper<OrderEntity> {
    @Override
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(rs.getLong("ID"));
        orderEntity.setFk_person(rs.getInt("fk_person"));
        orderEntity.setIssued(rs.getTimestamp("issued"));
        orderEntity.setVal(rs.getInt("val"));
        return orderEntity;
    }
}
