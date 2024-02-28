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

    @Override
    protected void interaction() {
        ArrayActions.printStringCool("Cathedra menu "+name,5);
    }
    public void cathedraPrintAllBy(String string, String who, int i) {
        if(who=="student"){
            for(Student student: students){
                if((i==1)&&(student.getName().equals(string))){
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
                if (teacher.getName().equals(string)) {
                    System.out.println(teacher);
                }
            }
        }
    }
}
