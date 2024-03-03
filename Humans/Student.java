package Humans;

public class Student extends Human{
    private Integer course;
    private Integer group;

    public Student(String name, Integer course, Integer group){
        super(name);
        this.course=course;
        this.group=group;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString() + (!isDeleted ? (", Course: " + course + ", Group: " + group+"\n") : "");
    }
}
