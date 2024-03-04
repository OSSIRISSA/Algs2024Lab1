package Menus;

import Humans.Human;
import Humans.Student;
import Humans.Teacher;
import utils.ArrayActions;
import utils.DataInput;

import java.io.IOException;

public class Faculty extends University{

    private Cathedra[] cathedra;
    protected Student[] students=new Student[0];
    protected Teacher[] teachers=new Teacher[0];

    public Faculty(){}
    public Faculty(String name) {
        this.name=name;
    }
    public Faculty(String name, Cathedra[] cathedra) {
        this.name=name;
        this.cathedra = new Cathedra[cathedra.length];
        System.arraycopy(cathedra, 0, this.cathedra, 0, cathedra.length);
        for (Cathedra cathedra1 : cathedra){
            cathedra1.updateData(this);
        }
    }

    @Override
    protected void interaction() throws IOException {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("Faculty " +this.name +" menu");
            int optionNumber = 0;
            for (Cathedra cathedra1:cathedra) {
                outputStr.append("\n" + ++optionNumber + ". Cathedra menu ").append(cathedra1.name);
            }
            outputStr.append("\n \n" + ++optionNumber + ". Display all students/teachers sorted by alphabet" + "\n" + ++optionNumber + ". Make changes in cathedra" + "\n" + ++optionNumber + ". Back");
            ArrayActions.printStringCool(outputStr.toString(), 5);

            int option = DataInput.getInt();
            if ((option <= optionNumber - 3)&& (option>0)) {
                cathedra[option - 1].interaction();
            } else if (option == optionNumber - 2) {
                this.displayAllByAlphabet();
            } else if (option == optionNumber-1) {
                this.change();
            } else if (option == optionNumber) {
                here = false;
            } else{
                System.out.println("Wrong option");
            }
        }
    }
    public boolean facultyPrintAllBy(String string, String who, int i) {
        boolean res = false;
        for(Cathedra cathedra0: cathedra){
            if(!res){
                res=cathedra0.cathedraPrintAllBy(string, who, i);
            } else {
                cathedra0.cathedraPrintAllBy(string, who, i);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 2
     *
     * @throws IOException
     */
    private void change() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("1. Add new cathedra \n 2. Delete any cathedra \n 3. Edit any cathedra \n 4. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> this.addNewCathedra();
                case 2 -> this.deleteCathedra();
                case 3 -> this.editCathedra();
                case 4 -> here = false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    /**
     * (2) editCathedra
     *
     * @throws IOException
     */
    private void editCathedra() throws IOException {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("Choose cathedra you want to change " + name);
            int optionNumber = 0;
            for (Cathedra cathedra0: cathedra) {
                outputStr.append("\n" + ++optionNumber + ". Cathedra ").append(cathedra0.name);
            }
            outputStr.append("\n" + ++optionNumber + ". Back ");
            ArrayActions.printStringCool(outputStr.toString(), 5);
            int option = DataInput.getInt();
            if ((option < optionNumber)&& (option>0)) {
                cathedra[option - 1].name = DataInput.getString("New name for this cathedra: ");
            } else if(option == optionNumber){
                here = false;
            }else{
                System.out.println("Wrong option");
            }
        }
    }

    /**
     * (2) deleteCathedra
     */
    private void deleteCathedra() {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("Choose cathedra you want to delete " + name);
            int optionNumber = 0;
            for (Cathedra cathedra0: cathedra) {
                outputStr.append("\n" + ++optionNumber + ". Cathedra ").append(cathedra0.name);
            }
            outputStr.append("\n" + ++optionNumber + ". Back ");
            ArrayActions.printStringCool(outputStr.toString(), 5);
            int option = DataInput.getInt();
            if ((option < optionNumber)&& (option>0)) {
                cathedra[option-1].deleteCathedraHumans();
                Cathedra[] copyArray = new Cathedra[cathedra.length - 1];
                System.arraycopy(cathedra, 0, copyArray, 0, option-1);
                System.arraycopy(cathedra, option, copyArray, option-1, cathedra.length-option);
                cathedra = copyArray;
            } else if(option == optionNumber){
                here = false;
            }else{
                System.out.println("Wrong option");
            }
        }
    }

    /**
     * (2) addNewCathedra
     *
     * @throws IOException - exception
     */
    private void addNewCathedra() throws IOException {
        cathedra = ArrayActions.append(cathedra, new Cathedra(DataInput.getString("New cathedra name: ")));
    }

    /**
     * 6
     */
    private void displayAllByAlphabet() {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("Display \n 1. Students \n 2. Teachers \n \n 3. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> {
                    Human.sortByNameUp(students);
                    boolean res = false;
                    for (Student student : students){
                        System.out.print(student);
                        if(!student.toString().isEmpty()){
                            res = true;
                        }
                    }
                    if(!res){
                        System.out.println("---");
                    }
                }
                case 2 -> {
                    Human.sortByNameUp(teachers);
                    boolean res = false;
                    for (Teacher teacher : teachers){
                        System.out.print(teacher);
                        if(!teacher.toString().isEmpty()){
                            res = true;
                        }
                    }
                    if(!res){
                        System.out.println("---");
                    }
                }
                case 3 -> here=false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    public void deleteFacultyHumans(){
        for (Student student: students){
            student.setDeleted(true);
        }
        for (Teacher teacher: teachers){
            teacher.setDeleted(true);
        }
    }

}
