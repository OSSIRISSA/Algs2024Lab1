package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {
    /**
     * Get int with input text
     *
     * @param input         - Text to be displayed in console
     * @return              - int from System.in
     */
    public static Integer getInt(String input){
        if (!input.isEmpty()) {
            System.out.print(input);
        }
        String s = "";
        try {
            s = getString();
        } catch (IOException ignored) {

        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e){
            return getInt("It is not a number. Enter another: " +"\n");
        }
    }

    /**
     * Get int with input text
     *
     * @return              - int from System.in
     */
    public static Integer getInt(){
        String s = "";
        try {
            s = getString();
        } catch (IOException ignored) {

        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e){
            return getInt("It is not a number. Enter another: " +"\n");
        }
    }

    /**
     * Get String with input text
     *
     * @param input         - Text to be displayed in console
     * @return              - String from System.in
     * @throws IOException  - exception
     */
    public static String getString(String input) throws IOException{
        System.out.print(input);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    /**
     * Get String without input text
     *
     * @return              - String from System.in
     * @throws IOException  - exception
     */
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}