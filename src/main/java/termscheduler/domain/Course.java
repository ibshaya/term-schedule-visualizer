package termscheduler.domain;

public abstract class Course {
    private  String code;
    private  String title;
    private String dept;
    private String kind;
    public  Course(String code, String title, String dept, String kind){
        this.code = code;
        this.title = title;
        this.dept = dept;
        this.kind = kind;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDept() {
        return dept;
    }

    public String getKind() {
        return kind;
    }

}

