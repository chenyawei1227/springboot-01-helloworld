package com.luckchen.testlambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: chenyawei
 * @Date: 2020-02-04  15:53
 * @Description:
 */
@Data
@AllArgsConstructor
public class Emplyee {

    private String name;
    private int age;
    private double salary;

}
