package prob2A;

public class Student {
    private String name;
    private Grade grade;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade.getGrade() +
                '}';
    }

    public Student(String name){
        this.name=name;
        grade=new Grade(this);
    }

    public Grade getGrade() {
        return grade;
    }
    public String getName() {
        return name;
    }

}

