package com.atguigu.bean;

/**
 * @Author chenxin
 * @date 2022/3/14
 * @Version 1.0
 */
public class Employee {
    private Integer id;
    private String name;
    private Integer gender;  // 0 男  1 女
    private Double salary;

    public String getValue(){
        return "atguigu";
    }

    public Employee() {
    }

    public Employee(Integer id, String name, Integer gender, Double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }
}
