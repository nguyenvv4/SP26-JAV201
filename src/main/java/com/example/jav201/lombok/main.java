package com.example.jav201.lombok;

public class main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setId("TH1012");
        student1.setName("Nguyen Thi B");
        student1.setAge(22);
        student1.setGender(false);
        Student student2 = new Student("TH1011", "Nguyen Van A", 19, true);
        Student student3 = Student.builder()
                .id("TH1013").name("Tran Van C").build();
        System.out.println(student3);
        System.out.println(student1);
        System.out.println(student2);
    }
}
