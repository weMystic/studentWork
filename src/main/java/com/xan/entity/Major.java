package com.xan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Major {
    private Integer id;
    private String majorId;
    private String name;
    private String deptId;
}
