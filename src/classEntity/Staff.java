package classEntity;

import java.time.LocalDate;
import java.util.List;

public class Staff extends User {
    private LocalDate hiredDate;
    private String position;
    private double salary;

    public Staff() {
        super();
        this.hiredDate = null;
        this.position = "Unknown";
        this.salary = 0.0;
    }
    
    public Staff(int id, String name, String gender, int age, String phone, 
            LocalDate hiredDate, String position, double salary) {
        super(id, name, gender, age, phone);
        this.hiredDate = hiredDate;
        this.position = position;
        this.salary = salary;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
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

    @Override public long getLoanPeriod(){
        return 14;
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

    @Override public String toString() {
        return super.toString() + " | " + getHiredDate() + " | " + getPosition() + " | " + getSalary();
    }
}