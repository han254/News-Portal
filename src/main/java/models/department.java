package models;

public class department {
    private int id;
    private String departmentname;
    private String description;
    private int numberOfEmployees;

    public department(String departmentname, String description, int numberOfEmployees) {
        this.departmentname = departmentname;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
    }

    public department(int id, String departmentname, String description, int numberOfEmployees) {
        this.id = id;
        this.departmentname = departmentname;
        this.description = description;
        this.numberOfEmployees = numberOfEmployees;
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
