package com.mac;

/**
 * @Author: Hiccup
 * @Date: 2020/4/16 15:51
 */
public class ThrowTest {

    public static void main(String[] args) {
        Student student = getObject(true);
        System.out.println(student);
    }

    private static Student getObject(boolean bo){
        try {
            if (bo) throw new NullPointerException();
            return new Student();
        } catch (Exception e){
            throw e;
        }
    }

}

class Student {
    public Student() {

    }
}
