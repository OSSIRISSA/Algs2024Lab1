package Menus;

import Humans.Student;
import Humans.Teacher;
import utils.ArrayActions;
import utils.DataInput;

import java.io.IOException;

public class University {
    protected String name;
    private static Faculty[] faculties;
    public University(String name) {
        this.name = name;
    }
    public University() {}

    public static void main(String[] args) throws IOException {
        University kma = new University("KMA");
        faculties = new Faculty[3];
        faculties[0] = new Faculty("FI", new Cathedra[]{new Cathedra("Math", new Student[]{new Student("Morgan Johnson", 2, 1), new Student("Jamie Garcia", 3, 2), new Student("Jordan Michael", 1, 3)}, new Teacher[]{new Teacher("Jamie Taylor"), new Teacher("Dakota Smith")}), new Cathedra("Informatics", new Student[]{new Student("Alex Harris", 1, 4), new Student("Cameron Thomas", 2, 1), new Student("Quinn Taylor", 3, 4)}, new Teacher[]{new Teacher("Skyler Anderson"), new Teacher("Harper Thomas")})});
        faculties[1] = new Faculty("FEN", new Cathedra[]{new Cathedra("Economics", new Student[]{new Student("Dakota Williams", 1, 2), new Student("Python Robinson", 2, 6), new Student("Robin Jackson", 1, 3)}, new Teacher[]{new Teacher("Casey Davis"), new Teacher("Jordan Garcia")}), new Cathedra("Economics History", new Student[]{new Student("Blake Jones", 2, 4), new Student("Morgan Moore", 1, 1), new Student("Jamie Taylor", 3, 2)}, new Teacher[]{new Teacher("Cameron Wilson"), new Teacher("Jordan White")}), new Cathedra("Finances", new Student[]{new Student("Skyler Martin", 3, 5), new Student("Quinn Smith", 1, 2), new Student("Lane Robinson", 3, 1)}, new Teacher[]{new Teacher("Quinn Miller"), new Teacher("Avery Taylor")})});
        faculties[2] = new Faculty("FSNST", new Cathedra[]{new Cathedra("Communication", new Student[]{new Student("Elliot Davis", 1, 5), new Student("Alex Martin", 3, 3), new Student("Elliot Miller", 3, 1)}, new Teacher[]{new Teacher("Harper Jones"), new Teacher("Drew Martinez")}), new Cathedra("Psychology", new Student[]{new Student("Drew Taylor", 2, 1), new Student("Dakota Johnson", 4, 4), new Student("Taylor Swift", 2, 2)}, new Teacher[]{new Teacher("Taylor Brown"), new Teacher("Jamie Martinez")})});
        kma.interaction();
    }


    protected void interaction() throws IOException {
        while (true){
            StringBuilder outputStr = new StringBuilder(" University menu " + name);
            int optionNumber = 0;
            for (Faculty faculty : faculties) {
                outputStr.append("\n").append(++optionNumber).append(". Faculty menu ").append(faculty.name);
            }
            outputStr.append("\n \n").append(++optionNumber).append(". Display all students sorted by course").append("\n").append(++optionNumber).append(". Find a student/teacher").append("\n").append(++optionNumber).append(". Make changes in faculties");
            ArrayActions.printStringCool(outputStr.toString(), 5);

            int option = DataInput.getInt();
            if ((option <= optionNumber - 3) && (option>0)) {
                faculties[option - 1].interaction();
            } else if (option == optionNumber - 2) {
                this.displayAllStudents();
            } else if (option == optionNumber - 1) {
                this.find();
            } else if (option == optionNumber) {
                this.change();
            }else {
                System.out.println("Wrong option");
            }
        }
    }

    /**
     * 1
     *
     * @throws IOException - exception
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
                default -> System.out.println("Wrong option");
            }
        }
    }

    /**
     * (1) editFaculty
     *
     * @throws IOException - exception
     */
    private void editFaculty() throws IOException {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("Choose faculty you want to change " + name);
            int optionNumber = 0;
            for (Faculty faculty : faculties) {
                outputStr.append("\n").append(++optionNumber).append(". Faculty ").append(faculty.name);
            }
            outputStr.append("\n").append(++optionNumber).append(". Back ");
            ArrayActions.printStringCool(outputStr.toString(), 5);
            int option = DataInput.getInt();
            if ((option < optionNumber)&& (option>0)) {
                faculties[option - 1].name = DataInput.getString("New name for this faculty: ");
            } else if(option == optionNumber){
                here = false;
            }else{
                System.out.println("Wrong option");
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
                outputStr.append("\n").append(++optionNumber).append(". Faculty ").append(faculty.name);
            }
            outputStr.append("\n").append(++optionNumber).append(". Back ");
            ArrayActions.printStringCool(outputStr.toString(), 5);
            int option = DataInput.getInt();
            if ((option < optionNumber)&& (option>0)) {
                faculties[option-1].deleteFacultyHumans();
                Faculty[] copyArray = new Faculty[faculties.length - 1];
                System.arraycopy(faculties, 0, copyArray, 0, option-1);
                System.arraycopy(faculties, option, copyArray, option-1, faculties.length-option);
                faculties = copyArray;
            } else if(option == optionNumber){
                here = false;
            }else{
                System.out.println("Wrong option");
            }
        }
    }

    /**
     * (1) addNewFaculty
     * @throws IOException - exception
     */
    private void addNewFaculty() throws IOException {
        faculties = ArrayActions.append(faculties, new Faculty(DataInput.getString("New faculty name: ")));
    }

    /**
     * 4
     * @throws IOException - exception
     */
    private void find() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("Find a \n 1. Student \n 2. Teacher \n \n 3. Back" , 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> {
                    ArrayActions.printStringCool("Find a student by \n 1. Name \n 2. Course \n 3. Group", 5);
                    int findBy;
                    do {
                        findBy = DataInput.getInt();
                        if (findBy < 1 || findBy > 3) System.out.println("Please, select from 1 to 3.");
                    } while (findBy < 1 || findBy > 3);
                    switch (findBy){
                        case 1-> {
                            if(this.printAllBy(DataInput.getString("Search: "), "student", findBy)){
                                System.out.println("No students found");
                            }
                        }
                        case 2 ->{
                            int findRequest;
                            do {
                                findRequest = DataInput.getInt("Search: ");
                                if (findRequest < 1 || findRequest > 4) System.out.println("Please, select course from 1 to 4.");
                            } while (findRequest < 1 || findRequest > 4);
                            if(this.printAllBy(String.valueOf(findRequest), "student", findBy)){
                                System.out.println("No students found");
                            }
                        }
                        case 3 ->{
                            int findRequest;
                            do {
                                findRequest = DataInput.getInt("Search: ");
                                if (findRequest < 1 || findRequest > 6) System.out.println("Please, select group from 1 to 6.");
                            } while (findRequest < 1 || findRequest > 6);
                            if(this.printAllBy(String.valueOf(findRequest), "student", findBy)){
                                System.out.println("No students found");
                            }
                        }
                        default -> System.out.println("Please, select from 1 to 3.");
                    }

                }
                case 2 -> {
                    if(this.printAllBy(DataInput.getString("Search: "), "teacher", 1)){
                        System.out.println("No teachers found");
                    }
                }
                case 3 -> here = false;
                default -> System.out.println("Wrong option");
            }

        }
    }

    /**
     * printAllBy
     *
     * @param string    - search request
     * @param who       - student/teacher
     * @param i         - 1.name/2.course/3.group
     */
    private boolean printAllBy(String string, String who, int i) {
        boolean res = false;
        for(Faculty faculty: faculties){
            if(!res){
                res=faculty.facultyPrintAllBy(string, who, i);
            } else {
                faculty.facultyPrintAllBy(string, who, i);
            }
        }
        return !res;
    }

    /**
     * 5
     */
    private void displayAllStudents() {
        for(int course = 1; course<=4; course++){
            boolean res = false;
            System.out.println("COURSE "+course+":");
            for(Faculty faculty: faculties){
                if(!res){
                    res = faculty.facultyPrintAllBy(String.valueOf(course), "student", 2);;
                } else {
                    faculty.facultyPrintAllBy(String.valueOf(course), "student", 2);
                }
            }
            if (!res){
                System.out.println("---");
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
