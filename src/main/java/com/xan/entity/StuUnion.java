package com.xan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuUnion {

    private String id;
    private String name;
    private Integer establishedYear;
    private String place;
}
