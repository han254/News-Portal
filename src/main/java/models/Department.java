package models;

import java.util.Objects;

public class Department {
    private int id;
    private String departmentname;
    private String description;
    private int numberOfEmployees;

    public Department(String departmentname, String description, int numberOfEmployees) {
        this.departmentname = departmentname;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
    }

    public Department(int id, String departmentname, String description, int numberOfEmployees) {
        this.id = id;
        this.departmentname = departmentname;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && numberOfEmployees == that.numberOfEmployees && departmentname.equals(that.departmentname) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentname, description, numberOfEmployees);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
