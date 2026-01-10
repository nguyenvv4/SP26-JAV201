package com.example.jav201.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String id;

    private String name;

    private int age;

    private Boolean gender;




}
