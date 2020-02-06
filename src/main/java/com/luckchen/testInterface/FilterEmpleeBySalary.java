package com.luckchen.testInterface;

import com.luckchen.testlambda.Emplyee;

/**
 * @Author: chenyawei
 * @Date: 2020-02-04  16:10
 * @Description:
 */
public class FilterEmpleeBySalary implements MyInterface<Emplyee> {

    @Override
    public boolean test(Emplyee emplyee) {
        return emplyee.getSalary() > 6666;
    }
}
