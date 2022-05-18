package models;

public class DepartmentNews {


    private int id;

    private String title;

    private String content;

    private String departmentName;

    public DepartmentNews(int id, String title, String content, String departmentName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return content;
    }

    public void setTitle(String title) {
        this.title= title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
