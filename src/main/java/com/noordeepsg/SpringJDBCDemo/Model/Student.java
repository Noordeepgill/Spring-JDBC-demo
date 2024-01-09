package com.noordeepsg.SpringJDBCDemo.Model;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private Number rollnumber;
    private String address;

    public Student(){
        System.out.println("This is student constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(Number rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollnumber=" + rollnumber +
                ", address='" + address + '\'' +
                '}';
    }
}
