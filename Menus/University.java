package Menus;

public class University extends Menu {

    private Faculty[] faculties = new Faculty[2];

    public University(){}

    public University(String name){
        this.name = name;
        faculties[0]=new Faculty("FI");

    }


    protected void interaction() {

        System.out.println("University menu "+name);
        faculties[0].interaction();

    }
}
