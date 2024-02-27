package utils;

import java.lang.reflect.Array;

public class ArrayActions {

    public static void printStringCool(String input, int margin){

        String[] lines = input.split("\n");

        int maxLength=0;
        for (String line : lines){
            if (maxLength<line.length()){
                maxLength=line.length();
            }
        }

        System.out.print("/");
        for (int i=0; i<maxLength+margin*2; i++){
            System.out.print("‾");
        }
        System.out.println("\\");

        for (String line : lines) {
            System.out.print("|");
            int leftPartOfSpaces = (maxLength - line.length()) / 2 + margin;
            //System.out.println(leftPartOfSpaces);
            //System.out.println(line.length());
            for (int j = 0; j < leftPartOfSpaces; j++) {
                System.out.print(" ");
            }
            System.out.print(line);
            for (int j = 0; j < maxLength+margin*2-leftPartOfSpaces-line.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        System.out.print("\\");
        for (int i=0; i<maxLength+margin*2; i++){
            System.out.print("_");
        }
        System.out.println("/");
    }


    public static <T> T[] append(T[] array, T element) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length + 1);
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;

        return newArray;
    }

}
