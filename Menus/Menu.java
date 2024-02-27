package Menus;

import java.util.Arrays;

public class Menu {
    protected String name;
    private static University[] universities= new University[2];

    public Menu(){}

    public static void main(String[] args) {
        Menu menu = new Menu();
        universities[0] = new University("KMA");
        menu.interaction();
    }

    protected void interaction(){

        System.out.println("Main menu");
        universities[0].interaction();

    }

    /*private static <T> T[] extendArr(T[] arr){

        T[] arrTemp;
        arrTemp = new T[arr.length*2];
        System.arraycopy(arr, 0, arrTemp, 0, arr.length);

        return arrTemp;

    }*/
}
