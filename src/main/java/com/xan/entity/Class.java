package com.xan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    private Integer classId;
    private Integer yearOfEnrollment;
    private Integer size; //总人数
    private String majorId;

}
