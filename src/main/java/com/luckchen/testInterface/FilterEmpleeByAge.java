package com.luckchen.testInterface;

import com.luckchen.testlambda.Emplyee;

/**
 * @Author: chenyawei
 * @Date: 2020-02-04  16:09
 * @Description:
 */
public class FilterEmpleeByAge implements MyInterface<Emplyee> {


    @Override
    public boolean test(Emplyee emplyee) {
        return emplyee.getAge() > 33;
    }
}
