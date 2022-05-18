package models;

public class News {
    private int id;

    private String title;

    private String content;

    private String departmentname;

    public News(String title, String content, String departmentname) {
        this.title = title;
        this.content = content;
        this.departmentname = departmentname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
