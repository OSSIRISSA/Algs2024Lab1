package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    public static Long getLong(String input) throws IOException{
        System.out.print(input);
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }
    public static Long getLong() throws IOException{
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar(String input) throws IOException{
        System.out.print(input);
        String s = getString();
        return s.charAt(0);
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static Integer getInt(String input){
        if (!input.isEmpty()) {
            System.out.print(input);
        }
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e){
            return getInt("It is not a number\n");
        }
    }

    public static Integer getInt(){
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e){
            return getInt("It is not a number");
        }
    }

    public static Double getDouble(String input){
        if (!input.isEmpty()) {
            System.out.print(input);
        }
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return Double.valueOf(s);
        } catch (NumberFormatException e){
            return getDouble("It is not a");
        }
    }

    public static Double getDouble(){
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            return Double.valueOf(s);
        } catch (NumberFormatException e){
            return getDouble("It is not a Double");
        }
    }

    public static String getString(String input) throws IOException{
        System.out.print(input);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}