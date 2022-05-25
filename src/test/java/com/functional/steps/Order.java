package com.functional.steps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Order {
    public long id;
    public long fk_person;
    public Timestamp issued;
    public long value;

    public static Order toOrders(ResultSet resultSet) throws SQLException {
        Order orders = new Order();
        orders.id = (resultSet.getLong("id"));
        orders.fk_person = (resultSet.getLong("fk_person"));
        orders.issued = (resultSet.getTimestamp("issued"));
        orders.value = (resultSet.getLong("val"));
        return orders;
    }
}
