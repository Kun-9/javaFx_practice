package com.example.javafxtest;

// 생성자를 통해 필드 값을 읽고, getter 메소드를 통해 값을 읽을 수 있는 클래스 구현
public class Student {
    private final String name;
    private final int korean;
    private final int math;
    private final int english;

    public Student(String name, int korean, int math, int english) {
        this.name = name;
        this.korean = korean;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public int getKorean() {
        return korean;
    }

    public int getMath() {
        return math;
    }

    public int getEnglish() {
        return english;
    }
}




