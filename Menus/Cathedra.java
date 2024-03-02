package Menus;

import Humans.*;
import utils.ArrayActions;

import java.util.Objects;

public class Cathedra extends Faculty{

    private Student[] students;
    private Teacher[] teachers;
    public Cathedra(String name) {
        this.name=name;
    }

    public Cathedra(String name, Student[] students, Teacher[] teachers) {
        this.name=name;
        this.students = new Student[students.length];
        System.arraycopy(students, 0, this.students, 0, students.length);
        this.teachers = new Teacher[teachers.length];
        System.arraycopy(teachers, 0, this.teachers, 0, teachers.length);
    }

    @Override
    protected void interaction() {
        ArrayActions.printStringCool("Cathedra menu "+name,5);
    }
    public void cathedraPrintAllBy(String string, String who, int i) {
        if(Objects.equals(who, "student")){
            for(Student student: students){
                if((i==1)&&(student.getName().contains(string))){
                    System.out.println(student);
                }
                else if((i==2)&&(Objects.equals(student.getCourse(), Integer.valueOf(string)))){
                    System.out.println(student);
                }
                else if((i==3)&&(Objects.equals(student.getGroup(), Integer.valueOf(string)))){
                    System.out.println(student);
                }
            }
        }
        else{
            for(Teacher teacher: teachers) {
                if (teacher.getName().contains(string)) {
                    System.out.println(teacher);
                }
            }
        }
    }
}
