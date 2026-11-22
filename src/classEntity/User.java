package classEntity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String phone;

    public User() {
        this.id = 0;
        this.name = "Unknown";
        this.gender = "Unknown";
        this.age = 0;
        this.phone = "N/A";
    }
    
    public User(int id, String name, String gender, int age, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    String getType() { return "USER"; }

    public abstract Duration getLoanPeriod();
    public abstract int getMaxBooks();

    public List<String> toFields() {
        return new ArrayList<>(List.of(
            getType(), String.valueOf(id), name, gender, String.valueOf(age), phone
        ));
    }
}
