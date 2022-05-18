package models;

public class DepartmentNews {
    private int departmentId;

    public DepartmentNews(String description, int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
