package com.example.javafxtest;

import java.util.ArrayList;

public class studentArrayList {

    ArrayList<Student> studentArrayList;

    public studentArrayList() {

    }

    public void addProduct(Student student) {
        studentArrayList.add(student);
    }

    public Student getProduct(int n) {
        return studentArrayList.get(n);
    }

}
