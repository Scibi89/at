package com.example.at.data;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    private long id;
    private int fk_person;
    private Timestamp issued;
    private int val;
}
