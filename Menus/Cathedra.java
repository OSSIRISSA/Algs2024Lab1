package Menus;

import Humans.*;
import utils.ArrayActions;

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
}
