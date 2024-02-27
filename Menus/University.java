package Menus;

import utils.ArrayActions;

public class University{
    protected String name;

    private static Faculty[] faculties;

    public University(String name){
        this.name = name;
    }
    public University(){}

    public static void main(String[] args) {
        University kma = new University("KMA");
        faculties = new Faculty[3];
        faculties[0]=new Faculty("FI");
        faculties[1]=new Faculty("FEN");
        faculties[2]=new Faculty("FSNST");
        kma.interaction();
    }


    protected void interaction() {

        StringBuilder outputStr = new StringBuilder("University menu "+name);
        for (Faculty faculty : faculties){
            outputStr.append("\n" + "Faculty menu ").append(faculty.name);
        }
        ArrayActions.printStringCool(outputStr.toString(),5);
    }
}
