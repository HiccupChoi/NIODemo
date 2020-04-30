package com.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hiccup
 * @Date: 2020/3/13 17:34
 */
public class ListTest {

    public static void main(String[] args) {

//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student("123", 10));
//        School school = new School(studentList);
//        List<Student> studentList1 = school.getStudentList();
//        for (Student student : studentList1) {
//            student.setAge(20);
//            student.setName("222");
//        }
//        System.out.println(studentList);
//        System.out.println(school);
//        System.out.println(studentList1);

        System.out.println((String) null);
    }

}

class School{
    private List<Student> studentList;

    public School(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "School{" + "studentList=" + studentList + '}';
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
