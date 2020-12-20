package com.xan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sjoin {
    private  int id;

    private int uid;
    
    private int sid;
    
    private int joinYear;
}
