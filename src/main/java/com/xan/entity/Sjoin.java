package com.xan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sjoin {
    private  Integer id;

    private String uid;
    
    private String sid;
    
    private int joinYear;
}
