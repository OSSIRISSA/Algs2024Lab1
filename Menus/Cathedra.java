package Menus;

import Humans.*;
import utils.ArrayActions;
import utils.DataInput;

import java.io.IOException;
import java.util.Objects;

public class Cathedra extends Faculty{

    private Faculty faculty;
    private Student[] students;
    private Teacher[] teachers;
    public Cathedra(String name) {
        this.name=name;
    }

    public Cathedra(String name, Student[] students, Teacher[] teachers) {
        this.name=name;
        this.students = new Student[students.length];
        System.arraycopy(students, 0, this.students, 0, students.length);

        this.teachers = new Teacher[teachers.length];
        System.arraycopy(teachers, 0, this.teachers, 0, teachers.length);
    }

    @Override
    protected void interaction() throws IOException {
        boolean here = true;
        while (here) {
            StringBuilder outputStr = new StringBuilder("Cathedra " +this.name +" menu");
            int optionNumber = 0;
            outputStr.append("\n \n" + ++optionNumber + ". Display all students sorted by course" + "\n" + ++optionNumber + ". Display all students/teachers sorted by alphabet" + "\n" + ++optionNumber + ". Display all students of any course sorted by alphabet" + "\n" + ++optionNumber + ". Make changes in humans" + "\n" + ++optionNumber + ". Back");
            ArrayActions.printStringCool(outputStr.toString(), 5);
            int option = DataInput.getInt();
            switch (option){
                case 1 -> this.displayAll();
                case 2 -> this.displayAllByAlphabet();
                case 3 -> this.displayAllOfCourse();
                case 4 -> this.change();
                case 5 -> here = false;
                default -> System.out.println("Wrong option");
            }
        }
    }
    public void cathedraPrintAllBy(String string, String who, int i) {
        if(Objects.equals(who, "student")){
            for(Student student: students){
                if((i==1)&&(student.getName().contains(string))){
                    System.out.print(student);
                }
                else if((i==2)&&(Objects.equals(student.getCourse(), Integer.valueOf(string)))){
                    System.out.print(student);
                }
                else if((i==3)&&(Objects.equals(student.getGroup(), Integer.valueOf(string)))){
                    System.out.print(student);
                }
            }
        }
        else if(Objects.equals(who, "teacher")){
            for(Teacher teacher: teachers) {
                if (teacher.getName().contains(string)) {
                    System.out.print(teacher);
                }
            }
        }
    }

    /**
     * 7
     */
    private void displayAll() {
        for(int course = 1; course<=4; course++){
            System.out.println("COURSE "+course+":");
            this.cathedraPrintAllBy(String.valueOf(course), "student", 2);
        }
    }

    public void updateData(Faculty faculty) {
        this.faculty=faculty;
        for (Student student : students){
            student.setFaculty(faculty);
            student.setCathedra(this);
            this.faculty.students=ArrayActions.append(this.faculty.students, student);
        }
        for (Teacher teacher : teachers){
            teacher.setFaculty(faculty);
            teacher.setCathedra(this);
            this.faculty.teachers=ArrayActions.append(this.faculty.teachers, teacher);
        }
    }

    public void deleteCathedraHumans(){
        for (Student student: students){
            student.setDeleted(true);
        }
        for (Teacher teacher: teachers){
            teacher.setDeleted(true);
        }
    }

    /**
     * 8
     */
    private void displayAllByAlphabet() {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("Display \n 1. Students \n 2. Teachers \n \n 3. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> {
                    Human.sortByNameUp(students);
                    for (Student student : students){
                        System.out.print(student);
                    }
                }
                case 2 -> {
                    Human.sortByNameUp(teachers);
                    for (Teacher teacher : teachers){
                        System.out.print(teacher);
                    }
                }
                case 3 -> here=false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    /**
     * 9,10
     */
    private void displayAllOfCourse() {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("Display \n 1. Course 1 \n 2. Course 2 \n 3. Course 3 \n 4. Course 4 \n \n 3. Back", 5);
            int option = DataInput.getInt();
            Human.sortByNameUp(students);
            if(option<=4){
                this.cathedraPrintAllBy(String.valueOf(option),"student", 2);
            } else if(option==5){
                here = false;
            } else {
                System.out.println("Wrong option");
            }
        }
    }

    /**
     * 3
     *
     * @throws IOException
     */
    private void change() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("1. Make changes in students \n 2. Make changes in teachers \n 3. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> this.changeStudents();
                case 2 -> this.changeTeachers();
                default -> System.out.println("Wrong option");
            }
        }
    }

    /**
     * (3) changeStudents
     *
     * @throws IOException
     */
    private void changeStudents() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("1. Add new student \n 2. Delete any student \n 3. Edit any student \n 4. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> this.addHuman("student");
                case 2 -> this.deleteHuman("student");
                case 3 -> this.editHuman("student");
                case 4 -> here = false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    /**
     * (3) changeTeachers
     *
     * @throws IOException
     */
    private void changeTeachers() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool("1. Add new teacher \n 2. Delete any teacher \n 3. Edit any teacher \n 4. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> this.addHuman("teacher");
                case 2 -> this.deleteHuman("teacher");
                case 3 -> this.editHuman("teacher");
                case 4 -> here = false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    /**
     * (3) addHuman
     * @param who - "student"/"teacher"
     * @throws IOException
     */
    private void addHuman(String who) throws IOException {
        if(who.equals("student")){
            students = ArrayActions.append(students, new Student(DataInput.getString("New student name:"), DataInput.getInt("New student course:"), DataInput.getInt("New student group:")));
        } else{
            teachers = ArrayActions.append(teachers, new Teacher(DataInput.getString("New teacher name:")));
        }
    }

    /**
     * (3) editHuman
     * @param who - "student"/"teacher"
     * @throws IOException
     */
    private void editHuman(String who) throws IOException {
        boolean here = true;
        while (here) {
            if(who.equals("student")){
                StringBuilder outputStr = new StringBuilder("Choose student you want to change " + name);
                int optionNumber = 0;
                for (Student student: students) {
                    outputStr.append("\n" + ++optionNumber + ". ").append(student);
                }
                outputStr.append("\n" + ++optionNumber + ". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if (option < optionNumber) {
                    ArrayActions.printStringCool(" 1. Change name \n 2. Change course \n 3. Change group", 5);
                    int whatToChange = DataInput.getInt();
                    switch (whatToChange){
                        case 1 -> students[option - 1].setName(DataInput.getString("New name for this student: "));
                        case 2 -> students[option - 1].setCourse(DataInput.getInt("New course for this student: "));
                        case 3 -> students[option - 1].setGroup(DataInput.getInt("New group for this student: "));
                        default -> System.out.println("Wrong option");
                    }
                } else if(option == optionNumber){
                    here = false;
                }else{
                    System.out.println("Wrong option");
                }
            } else{
                StringBuilder outputStr = new StringBuilder("Choose teacher you want to change " + name);
                int optionNumber = 0;
                for (Teacher teacher: teachers) {
                    outputStr.append("\n" + ++optionNumber + ". ").append(teacher);
                }
                outputStr.append("\n" + ++optionNumber + ". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if (option < optionNumber) {
                    teachers[option - 1].setName(DataInput.getString("New name for this teacher: "));
                } else if(option == optionNumber){
                    here = false;
                }else{
                    System.out.println("Wrong option");
                }
            }
        }
    }

    /**
     * (3) deleteHuman
     * @param who - "student"/"teacher"
     */
    private void deleteHuman(String who) {
        boolean here = true;
        while (here) {
            if(who.equals("student")){
                StringBuilder outputStr = new StringBuilder("Choose student you want to delete " + name);
                int optionNumber = 0;
                for (Student student : students) {
                    outputStr.append("\n").append(++optionNumber).append(". ").append(student);
                }
                outputStr.append("\n").append(++optionNumber).append(". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if (option < optionNumber) {
                    Student[] copyArray = new Student[students.length - 1];
                    System.arraycopy(students, 0, copyArray, 0, option-1);
                    System.arraycopy(students, option, copyArray, option-1, students.length-option);
                    students = copyArray;
                } else if(option == optionNumber){
                    here = false;
                }else{
                    System.out.println("Wrong option");
                }
            } else{
                StringBuilder outputStr = new StringBuilder("Choose teacher you want to delete " + name);
                int optionNumber = 0;
                for (Teacher teacher : teachers) {
                    outputStr.append("\n").append(++optionNumber).append(". ").append(teacher);
                }
                outputStr.append("\n").append(++optionNumber).append(". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if (option < optionNumber) {
                    Teacher[] copyArray = new Teacher[students.length - 1];
                    System.arraycopy(teachers, 0, copyArray, 0, option-1);
                    System.arraycopy(teachers, option, copyArray, option-1, teachers.length-option);
                    teachers = copyArray;
                } else if(option == optionNumber){
                    here = false;
                }else{
                    System.out.println("Wrong option");
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
