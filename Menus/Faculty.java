package Menus;

import utils.ArrayActions;

public class Faculty extends University{

    private Cathedra[] cathedra = new Cathedra[2];

    public Faculty(){}
    public Faculty(String name) {
        this.name=name;
        cathedra[0]=new Cathedra("Math");

    }

    @Override
    protected void interaction() {
        ArrayActions.printStringCool("Faculty menu "+name,5);
        cathedra[0].interaction();
    }
}
