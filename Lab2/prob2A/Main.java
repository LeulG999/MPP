package prob2A;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Student> students=new ArrayList<>();
        Student s1=new Student("Leul");
        students.add(s1);
        s1.getGrade().setGrade("A-");
        Student s2=new Student("Nati");
        students.add(s2);
        s2.getGrade().setGrade("A");
        Student s3=new Student("Rahul");
        students.add(s3);
        s3.getGrade().setGrade("A+");
        Student s4=new Student("Linda");
        students.add(s4);
        s4.getGrade().setGrade("B+");
        Student s5=new Student("Chris");
        students.add(s5);
        s5.getGrade().setGrade("B-");
        System.out.println(students);
    }
}
