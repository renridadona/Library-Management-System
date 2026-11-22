package classEntity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Staff extends User {
    private LocalDateTime hiredDate;
    private String position;
    private double salary;

    public Staff() {
        super();
        this.hiredDate = null;
        this.position = "Unknown";
        this.salary = 0.0;
    }
    
    public Staff(int id, String name, String gender, int age, String phone, 
            LocalDateTime hiredDate, String position, double salary) {
        super(id, name, gender, age, phone);
        this.hiredDate = hiredDate;
        this.position = position;
        this.salary = salary;
    }

    public LocalDateTime getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDateTime hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override String getType() { return "STAFF"; }

    @Override public Duration getLoanPeriod(){
        return Duration.ofDays(14);
    }

    @Override public int getMaxBooks(){
        return 5;
    }

    @Override public List<String> toFields(){
        List<String> f = super.toFields();
        f.add(hiredDate.toString());
        f.add(position);
        f.add(String.valueOf(salary));
        return f;
    }
}