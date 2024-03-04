package Humans;

import Menus.Cathedra;
import Menus.Faculty;

public class Human {
    protected String name;
    protected Cathedra cathedra;
    protected Faculty faculty;
    protected boolean isDeleted;

    /**
     * Constructor
     *
     * @param name  - Name of human
     */
    public Human(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
        return this;
    }

    public Human setFaculty(Faculty faculty) {
        this.faculty = faculty;
        return this;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Sort array of humans by alphabet
     *
     * @param array     - In array of humans
     */
    public static void sortByNameUp(Human[] array){
        int currentPosition = 0;

        while (currentPosition < array.length - 1) {
            if (array[currentPosition].getName().compareTo(array[currentPosition + 1].getName())>0) {

                Human temp = array[currentPosition];
                array[currentPosition] = array[currentPosition + 1];
                array[currentPosition + 1] = temp;
                if (currentPosition > 0) {
                    currentPosition--;

                }
            } else {
                currentPosition++;
            }

        }
    }

    @Override
    public String toString() {
        return !isDeleted ? ("Faculty: "+faculty+", Cathedra: "+cathedra+", Data: "+name) : "" ;
    }
}
