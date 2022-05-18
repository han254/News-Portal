package models;

import java.util.Objects;

public class Department {
    private int id;
    private String departmentName;
    private String description;
    private int numberOfEmployees;

    public Department(String departmentName, String description, int numberOfEmployees) {
        this.departmentName = departmentName;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
    }

    public Department(int id, String departmentName, String description, int numberOfEmployees) {
        this.id = id;
        this.departmentName = departmentName;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && numberOfEmployees == that.numberOfEmployees && departmentName.equals(that.departmentName) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, description, numberOfEmployees);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
