package com.xan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    private Integer id;
    private String deptId;
    private String name;
    private String place;
    private Integer size;
}
