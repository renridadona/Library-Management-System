package Class;

import java.time.Duration;

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

    @Override public Duration getLoanPeriod(){
        return Duration.ofDays(7);
    }

    @Override public int getMaxBooks(){
        return 3;
    }
}
