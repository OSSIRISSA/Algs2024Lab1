package utils;
import java.lang.reflect.Array;

public class ArrayActions {
    private final static String RESET = "\u001B[0m";
    private final static String RED = "\u001B[31m";

    /**
     * Draw cool frame around formatted text
     *
     * @param input     - In string with \n
     * @param margin    - Margin from one side
     */
    public static void printStringCool(String input, int margin){
        String[] lines = input.split("\n");

        int maxLength=0;
        for (String line : lines){
            if (maxLength<line.length()){
                maxLength=line.length();
            }
        }

        System.out.print("╔═"+RED+"[===]"+RESET);
        int minSpacesAmount = Math.max(maxLength + margin * 2 - 12, 1);
        for (int i = 0; i< minSpacesAmount; i++){
            System.out.print("═");
        }
        System.out.println(RED+"[===]"+RESET+"═╗");

        for (String line : lines) {
            System.out.print("║");
            int leftPartOfSpaces = (maxLength - line.length()) / 2 + margin;
            for (int j = 0; j < leftPartOfSpaces; j++) {
                System.out.print(" ");
            }
            System.out.print(line);
            for (int j = 0; j < maxLength+margin*2-leftPartOfSpaces-line.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("║");
        }

        System.out.print("╚═"+RED+"[===]"+RESET);
        for (int i = 0; i< minSpacesAmount; i++){
            System.out.print("═");
        }
        System.out.println(RED+"[===]"+RESET+"═╝");
    }

    /**
     *
     *
     * @param array     - Array of type <T> that we want to append to
     * @param element   - Element of type <T> that we want to append
     * @return          - New array with appended element
     * @param <T>       - Array type
     */
    public static <T> T[] append(T[] array, T element) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length + 1);
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;

        return newArray;
    }
}
