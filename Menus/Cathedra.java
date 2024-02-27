package Menus;

import Humans.*;

public class Cathedra extends Faculty{

    private Student[] students;
    private Teacher[] teachers;
    public Cathedra(String name) {
        this.name=name;
    }

    @Override
    protected void interaction() {
        System.out.println("Cathedra menu "+name);
    }
}
