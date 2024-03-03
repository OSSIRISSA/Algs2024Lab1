package Humans;

import Menus.Cathedra;
import Menus.Faculty;

public class Human {
    protected String name;
    protected Cathedra cathedra;
    protected Faculty faculty;

    protected boolean isDeleted;
    public Human(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cathedra getCathedra() {
        return cathedra;
    }

    public void setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

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


    public static void sortByNameDown(Human[] array){
        int currentPosition = 0;

        while (currentPosition < array.length - 1) {
            if (array[currentPosition].getName().compareTo(array[currentPosition + 1].getName())<0) {

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
