package com.example.at.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private long id;
    private int fk_person;
    private Timestamp issued;
    private int val;
}
