package Humans;

import Menus.Cathedra;
import Menus.Faculty;

public class Human {
    protected String name;
    protected Cathedra cathedra;
    protected Faculty faculty;

    public Human(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cathedra getCathedra() {
        return cathedra;
    }

    public void setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Faculty: "+faculty+", Cathedra: "+cathedra+", Data: "+name;
    }
}
