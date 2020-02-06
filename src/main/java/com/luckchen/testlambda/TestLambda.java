package com.luckchen.testlambda;

import com.luckchen.testInterface.FilterEmpleeByAge;
import com.luckchen.testInterface.FilterEmpleeBySalary;
import com.luckchen.testInterface.MyInterface;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @Author: chenyawei
 * @Date: 2020-02-03  14:53
 * @Description:
 */
public class TestLambda {

    @Test
    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(1);
        treeSet.add(10);
        treeSet.add(9);
        treeSet.add(8);

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    List<Emplyee> emplyees = Arrays.asList(
            new Emplyee("aa", 11, 9999.9),
            new Emplyee("bb",22, 8888.8),
            new Emplyee("cc",33, 7777.7),
            new Emplyee("dd",44, 6666.6),
            new Emplyee("ee",55, 5555.5),
            new Emplyee("ff",66, 4444.4)
    );


    public List<Emplyee> filterEmployee(List<Emplyee> list, MyInterface<Emplyee> mp){
        List<Emplyee> emps = new ArrayList<>();
        for (Emplyee emplyee : list) {
            if(mp.test(emplyee)){
                emps.add(emplyee);
            }
        }
        return emps;
    }

    //优化方式一： 策略模式
    @Test
    public void test3(){
        List<Emplyee> list = filterEmployee(emplyees, new FilterEmpleeByAge());
        list.forEach(System.out::println);

        System.out.println("-------------------------------");

        List<Emplyee> list2 = filterEmployee(emplyees, new FilterEmpleeBySalary());
        list2.forEach(System.out::println);
    }



    //优化方式二：匿名内部类
    @Test
    public void test4(){
        List<Emplyee> list = filterEmployee(emplyees, new MyInterface<Emplyee>() {
            @Override
            public boolean test(Emplyee emplyee) {
                return emplyee.getSalary() > 6666;
            }
        });
        list.forEach(System.out::println);
    }

    //优化方式三：Lambda表达式
    @Test
    public void test5(){
        List<Emplyee> list = filterEmployee(emplyees,(e) -> e.getSalary() <= 6666);
        list.forEach(System.out::println);
    }

    //优化方法四：Stream API
    @Test
    public void test6(){
        emplyees.stream()
                .filter((e) -> e.getSalary() >= 6666)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-----------------------");

        emplyees.stream()
                .filter((e) -> e.getSalary() >= 7777)
                .map(Emplyee::getName)
                .forEach(System.out::println);
    }

}
