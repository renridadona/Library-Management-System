package classEntity;

import java.util.List;

public class Student extends User {
    private String course;
    private int year;

    public Student() {
        super();
        this.course = "Unknown";
        this.year = 0;
    }
    
    public Student(int id, String name, String gender, int age, String phone, String course, int year) {
        super(id, name, gender, age, phone);
        this.course = course;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override String getType() { return "STUDENT"; }

    @Override public long getLoanPeriod(){
        return 7;
    }

    @Override public int getMaxBooks(){
        return 3;
    }

    @Override public List<String> toFields(){
        List<String> f = super.toFields();
        f.add(course);
        f.add(String.valueOf(year));
        return f;
    }

    @Override public String toString() {
        return super.toString() + " | " + getCourse() + " | " + getYear();
    }
}
