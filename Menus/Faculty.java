package Menus;

public class Faculty extends University{

    private Cathedra[] cathedra = new Cathedra[2];

    public Faculty(){}
    public Faculty(String name) {
        this.name=name;
        cathedra[0]=new Cathedra("Math");

    }

    @Override
    protected void interaction() {
        System.out.println("Faculty menu "+name);
        cathedra[0].interaction();
    }
}
