package Menus;

import Humans.Student;
import utils.ArrayActions;
import utils.DataInput;

import java.io.IOException;

public class University {
    protected String name;

    private static Faculty[] faculties;


    public University(String name) {
        this.name = name;
    }

    public University() {
    }

    public static void main(String[] args) throws IOException {
        University kma = new University("KMA");
        faculties = new Faculty[3];
        faculties[0] = new Faculty("FI");
        faculties[1] = new Faculty("FEN");
        faculties[2] = new Faculty("FSNST");
        kma.interaction();
    }


    protected void interaction() throws IOException {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("University menu " + name);
            int optionNumber = 0;
            for (Faculty faculty : faculties) {
                outputStr.append("\n" + ++optionNumber + ". Faculty menu ").append(faculty.name);
            }
            outputStr.append("\n \n" + ++optionNumber + ". Display all students sorted by course" + "\n" + ++optionNumber + ". Find a student/teacher" + "\n" + ++optionNumber + ". Make changes in faculties");
            ArrayActions.printStringCool(outputStr.toString(), 5);

            int option = DataInput.getInt();
            if (option <= optionNumber - 3) {
                faculties[option - 1].interaction();
            } else if (option == optionNumber - 2) {
                this.displayAllStudents();
            } else if (option == optionNumber - 1) {
                this.find();
            } else if (option == optionNumber) {
                this.change();
            }
        }
    }

    /**
     * 1
     *
     * @throws IOException
     */
    private void change() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("1. Add new faculty \n 2. Delete any faculty \n 3. Edit any faculty \n 4. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> this.addNewFaculty();
                case 2 -> this.deleteFaculty();
                case 3 -> this.editFaculty();
                case 4 -> here = false;
            }
        }
    }

    /**
     * (1) editFaculty
     *
     * @throws IOException
     */
    private void editFaculty() throws IOException {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("Choose faculty you want to change " + name);
            int optionNumber = 0;
            for (Faculty faculty : faculties) {
                outputStr.append("\n" + ++optionNumber + ". Faculty ").append(faculty.name);
            }
            outputStr.append("\n" + ++optionNumber + ". Back ");
            ArrayActions.printStringCool(outputStr.toString(), 5);
            int option = DataInput.getInt();
            if (option != optionNumber) {
                faculties[option - 1].name = DataInput.getString("New name for this faculty: ");
            } else {
                here = false;
            }
        }
    }

    /**
     * (1) deleteFaculty
     */
    private void deleteFaculty() {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("Choose faculty you want to delete " + name);
            int optionNumber = 0;
            for (Faculty faculty : faculties) {
                outputStr.append("\n" + ++optionNumber + ". Faculty ").append(faculty.name);
            }
            outputStr.append("\n" + ++optionNumber + ". Back ");
            ArrayActions.printStringCool(outputStr.toString(), 5);
            int option = DataInput.getInt();
            if (option != optionNumber) {
                Faculty[] copyArray = new Faculty[faculties.length - 1];
                System.arraycopy(faculties, 0, copyArray, 0, copyArray.length);
                faculties = copyArray;
            } else {
                here = false;
            }
        }
    }

    /**
     * (1) addNewFaculty
     *
     * @throws IOException
     */
    private void addNewFaculty() throws IOException {
        faculties = ArrayActions.append(faculties, new Faculty(DataInput.getString("New faculty name:")));
    }

    /**
     * 4
     * @throws IOException
     */
    private void find() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("Find a \n 1. Student \n 2. Teacher \n \n 3. Back" , 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> {
                    ArrayActions.printStringCool("Find a student by \n 1. Name \n 2. Course \n 3. Group", 5);
                    int findBy = DataInput.getInt();
                    this.printAllBy(DataInput.getString("Search: "), "student" ,findBy);
                }
                case 2 -> {
                    this.printAllBy(DataInput.getString("Search: "), "teacher", 1);
                }
                case 3 -> here = false;
            }

        }
    }

    /**
     * printAllBy
     * @param string - search request
     * @param who - student/teacher
     * @param i - 1.name/2.course/3.group
     */
    private void printAllBy(String string, String who, int i) {
        for(Faculty faculty: faculties){
            faculty.facultyPrintAllBy(string, who, i);
        }
    }

    /**
     * 5
     */
    private void displayAllStudents() {
        for(int course = 1; course<=4; course++){
            System.out.println("COURSE 1:");
            for(Faculty faculty: faculties){
                faculty.facultyPrintAllBy(String.valueOf(course), "student", 2);
            }
        }
    }

}
