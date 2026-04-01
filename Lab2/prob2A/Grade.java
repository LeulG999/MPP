package prob2A;
public class Grade {
    private Student student;
    Grade(Student student){
        this.student=student;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Student getStudent() {
        return student;
    }
    public String getGrade() {
        return grade;
    }
    private String grade;

}
