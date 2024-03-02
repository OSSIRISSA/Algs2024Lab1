package Menus;

import utils.ArrayActions;

public class Faculty extends University{

    private Cathedra[] cathedra;

    public Faculty(){}
    public Faculty(String name) {
        this.name=name;
    }
    public Faculty(String name, Cathedra[] cathedra) {
        this.name=name;
        this.cathedra = new Cathedra[cathedra.length];
        System.arraycopy(cathedra, 0, this.cathedra, 0, cathedra.length);
    }

    @Override
    protected void interaction() {
        ArrayActions.printStringCool("Faculty menu "+name,5);
    }
    public void facultyPrintAllBy(String string, String who, int i) {
        for(Cathedra cathedra0: cathedra){
            cathedra0.cathedraPrintAllBy(string, who, i);
        }
    }
}
