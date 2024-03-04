package Menus;

import Humans.*;
import utils.ArrayActions;
import utils.DataInput;

import java.io.IOException;
import java.util.Objects;

public class Cathedra extends Faculty {

    private Faculty faculty;
    private Student[] students;
    private Teacher[] teachers;

    public Cathedra(String name) {
        this.name = name;
        this.students = new Student[0];
        this.teachers = new Teacher[0];
    }

    public Cathedra(String name, Student[] students, Teacher[] teachers) {
        this.name = name;
        this.students = new Student[students.length];
        System.arraycopy(students, 0, this.students, 0, students.length);

        this.teachers = new Teacher[teachers.length];
        System.arraycopy(teachers, 0, this.teachers, 0, teachers.length);
    }

    @Override
    protected void interaction() throws IOException {
        boolean here = true;
        while (here) {
            int optionNumber = 0;
            ArrayActions.printStringCool("Cathedra " + this.name + " menu" + "\n \n" + ++optionNumber + ". Display all students sorted by course" + "\n" + ++optionNumber + ". Display all students/teachers sorted by alphabet" + "\n" + ++optionNumber + ". Display all students of any course sorted by alphabet" + "\n" + ++optionNumber + ". Make changes in humans" + "\n" + ++optionNumber + ". Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> this.displayAll();
                case 2 -> this.displayAllByAlphabet();
                case 3 -> this.displayAllOfCourse();
                case 4 -> this.change();
                case 5 -> here = false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    public boolean cathedraPrintAllBy(String string, String who, int i) {
        boolean res = false;
        if (Objects.equals(who, "student")) {
            for (Student student : students) {
                if ((i == 1) && (student.getName().contains(string))) {
                    System.out.print(student);
                    res = true;
                } else if ((i == 2) && (Objects.equals(student.getCourse(), Integer.valueOf(string)))) {
                    System.out.print(student);
                    res = true;
                } else if ((i == 3) && (Objects.equals(student.getGroup(), Integer.valueOf(string)))) {
                    System.out.print(student);
                    res = true;
                }
            }
        } else if (Objects.equals(who, "teacher")) {
            for (Teacher teacher : teachers) {
                if (teacher.getName().contains(string)) {
                    System.out.print(teacher);
                    res = true;
                }
            }
        }
        return res;
    }

    /**
     * 7
     */
    private void displayAll() {
        for (int course = 1; course <= 4; course++) {
            System.out.println("COURSE " + course + ":");
            if (!this.cathedraPrintAllBy(String.valueOf(course), "student", 2)) {
                System.out.println("---");
            }
        }
    }

    public void updateData(Faculty faculty) {
        this.faculty = faculty;
        for (Student student : students) {
            student.setFaculty(faculty);
            student.setCathedra(this);
            this.faculty.students = ArrayActions.append(this.faculty.students, student);
        }
        for (Teacher teacher : teachers) {
            teacher.setFaculty(faculty);
            teacher.setCathedra(this);
            this.faculty.teachers = ArrayActions.append(this.faculty.teachers, teacher);
        }
    }

    public void deleteCathedraHumans() {
        for (Student student : students) {
            student.setDeleted(true);
        }
        for (Teacher teacher : teachers) {
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
                    boolean res = false;
                    for (Student student : students) {
                        System.out.print(student);
                        if (!student.toString().isEmpty()) {
                            res = true;
                        }
                    }
                    if (!res) {
                        System.out.println("---");
                    }
                }
                case 2 -> {
                    Human.sortByNameUp(teachers);
                    boolean res = false;
                    for (Teacher teacher : teachers) {
                        System.out.print(teacher);
                        if (!teacher.toString().isEmpty()) {
                            res = true;
                        }
                    }
                    if (!res) {
                        System.out.println("---");
                    }
                }
                case 3 -> here = false;
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
            ArrayActions.printStringCool("Display \n 1. Course 1 \n 2. Course 2 \n 3. Course 3 \n 4. Course 4 \n \n 5. Back", 5);
            int option = DataInput.getInt();
            Human.sortByNameUp(students);
            if ((option <= 4) && (option > 0)) {
                if (!this.cathedraPrintAllBy(String.valueOf(option), "student", 2)) {
                    System.out.println("---");
                }
            } else if (option == 5) {
                here = false;
            } else {
                System.out.println("Wrong option");
            }
        }
    }

    /**
     * 3
     *
     * @throws IOException - exception
     */
    private void change() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool(" 1. Make changes in students \n 2. Make changes in teachers \n 3. Back", 5);
            int option = DataInput.getInt();
            switch (option) {
                case 1 -> this.changeStudents();
                case 2 -> this.changeTeachers();
                case 3 -> here = false;
                default -> System.out.println("Wrong option");
            }
        }
    }

    /**
     * (3) changeStudents
     *
     * @throws IOException - exception
     */
    private void changeStudents() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool(" 1. Add new student \n 2. Delete any student \n 3. Edit any student \n 4. Back", 5);
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
     * @throws IOException - exception
     */
    private void changeTeachers() throws IOException {
        boolean here = true;
        while (here) {
            ArrayActions.printStringCool(" 1. Add new teacher \n 2. Delete any teacher \n 3. Edit any teacher \n 4. Back", 5);
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
     *
     * @param who - "student"/"teacher"
     * @throws IOException - exception
     */
    private void addHuman(String who) throws IOException {
        if (who.equals("student")) {
            String newName;
            boolean ok;
            do {
                newName = DataInput.getString("New student name: ");
                ok = true;
                for (int i = 0; i < newName.length(); i++) {
                    if (!(((newName.charAt(i) >= 'a') && (newName.charAt(i) <= 'z')) || ((newName.charAt(i) >= 'A') && (newName.charAt(i) <= 'Z')) || (newName.charAt(i) == ' '))) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) System.out.println("Please, type correct name");
            } while (!ok);

            int newCourse;
            do {
                newCourse = DataInput.getInt("New student course: ");
                if (newCourse < 1 || newCourse > 4) System.out.println("Please, select course from 1 to 4.");
            } while (newCourse < 1 || newCourse > 4);

            int newGroup;
            do {
                newGroup = DataInput.getInt("New student group: ");
                if (newGroup < 1 || newGroup > 6) System.out.println("Please, select group from 1 to 6.");
            } while (newGroup < 1 || newGroup > 6);

            if(findIdenticalStudent(newName,newCourse,newGroup)){
                ArrayActions.printStringCool(" Identical student found. Are you sure you want to add this one? \n 1. Yes \n 2. No ", 5);
                int variant = DataInput.getInt();
                switch (variant){
                    case 1 -> students = (Student[]) ArrayActions.append(students, new Student(newName, newCourse, newGroup).setFaculty(this.faculty).setCathedra(this));
                    case 2 -> {}
                    default -> System.out.println("Wrong option");
                }
            }else{
                students = (Student[]) ArrayActions.append(students, new Student(newName, newCourse, newGroup).setFaculty(this.faculty).setCathedra(this));
            }

        } else {

            String newName;
            boolean ok;
            do {
                newName = DataInput.getString("New teacher name: ");
                ok = true;
                for (int i = 0; i < newName.length(); i++) {
                    if (!(((newName.charAt(i) >= 'a') && (newName.charAt(i) <= 'z')) || ((newName.charAt(i) >= 'A') && (newName.charAt(i) <= 'Z')) || (newName.charAt(i) == ' '))) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) System.out.println("Please, type correct name");
            } while (!ok);

            if(findIdenticalTeacher(newName)){
                ArrayActions.printStringCool(" Identical teacher found. Are you sure you want to add this one? \n 1. Yes \n 2. No ", 5);
                int variant = DataInput.getInt();
                switch (variant){
                    case 1 -> teachers = (Teacher[]) ArrayActions.append(teachers, new Teacher(newName).setFaculty(this.faculty).setCathedra(this));
                    case 2 -> {}
                    default -> System.out.println("Wrong option");
                }
            }else{
                teachers = (Teacher[]) ArrayActions.append(teachers, new Teacher(newName).setFaculty(this.faculty).setCathedra(this));
            }

        }
    }

    /**
     * (3) editHuman
     *
     * @param who - "student"/"teacher"
     * @throws IOException - exception
     */
    private void editHuman(String who) throws IOException {
        boolean here = true;
        while (here) {
            if (who.equals("student")) {
                StringBuilder outputStr = new StringBuilder("Choose student you want to change in " + name);
                int optionNumber = 0;
                for (Student student : students) {
                    outputStr.append("\n").append(++optionNumber).append(". ").append(student);
                }
                outputStr.append("\n").append(++optionNumber).append(". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if ((option < optionNumber) && (option > 0)) {
                    boolean here2 = true;
                    while (here2) {
                        ArrayActions.printStringCool(" 1. Change name \n 2. Change course \n 3. Change group \n 4. Back ", 5);
                        int whatToChange = DataInput.getInt();
                        switch (whatToChange) {
                            case 1 -> {
                                String newName;
                                boolean ok;
                                do {
                                    newName = DataInput.getString("New name for this student: ");
                                    ok = true;
                                    for (int i = 0; i < newName.length(); i++) {
                                        if (!(((newName.charAt(i) >= 'a') && (newName.charAt(i) <= 'z')) || ((newName.charAt(i) >= 'A') && (newName.charAt(i) <= 'Z')) || (newName.charAt(i) == ' '))) {
                                            ok = false;
                                            break;
                                        }
                                    }
                                    if (!ok) System.out.println("Please, type correct name");
                                } while (!ok);

                                if(findIdenticalStudent(newName,students[option - 1].getCourse(),students[option - 1].getGroup())){
                                    ArrayActions.printStringCool(" Identical student found. Are you sure you want to change this field? \n 1. Yes \n 2. No ", 5);
                                    int variant = DataInput.getInt();
                                    switch (variant){
                                        case 1 -> students[option - 1].setName(newName);
                                        case 2 -> {}
                                        default -> System.out.println("Wrong option");
                                    }
                                }else{
                                    students[option - 1].setName(newName);
                                }
                            }
                            case 2 -> {
                                int newCourse;
                                do {
                                    newCourse = DataInput.getInt("New course for this student: ");
                                    if (newCourse < 1 || newCourse > 4) System.out.println("Please, select course from 1 to 4.");
                                } while (newCourse < 1 || newCourse > 4);

                                if(findIdenticalStudent(students[option - 1].getName(),newCourse,students[option - 1].getGroup())){
                                    ArrayActions.printStringCool(" Identical student found. Are you sure you want to change this field? \n 1. Yes \n 2. No ", 5);
                                    int variant = DataInput.getInt();
                                    switch (variant){
                                        case 1 -> students[option - 1].setCourse(newCourse);
                                        case 2 -> {}
                                        default -> System.out.println("Wrong option");
                                    }
                                }else{
                                    students[option - 1].setCourse(newCourse);
                                }

                            }
                            case 3 -> {
                                int newGroup;
                                do {
                                    newGroup = DataInput.getInt("New group for this student: ");
                                    if (newGroup < 1 || newGroup > 6) System.out.println("Please, select group from 1 to 6.");
                                } while (newGroup < 1 || newGroup > 6);

                                if(findIdenticalStudent(students[option - 1].getName(),students[option - 1].getCourse(),newGroup)){
                                    ArrayActions.printStringCool(" Identical student found. Are you sure you want to change this field? \n 1. Yes \n 2. No ", 5);
                                    int variant = DataInput.getInt();
                                    switch (variant){
                                        case 1 -> students[option - 1].setGroup(newGroup);
                                        case 2 -> {}
                                        default -> System.out.println("Wrong option");
                                    }
                                }else{
                                    students[option - 1].setGroup(newGroup);
                                }

                            }
                            case 4 -> here2 = false;
                            default -> System.out.println("Wrong option");
                        }
                    }
                } else if (option == optionNumber) {
                    here = false;
                } else {
                    System.out.println("Wrong option");
                }
            } else {
                StringBuilder outputStr = new StringBuilder("Choose teacher you want to change in " + name);
                int optionNumber = 0;
                for (Teacher teacher : teachers) {
                    outputStr.append("\n").append(++optionNumber).append(". ").append(teacher);
                }
                outputStr.append("\n").append(++optionNumber).append(". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if ((option < optionNumber) && (option > 0)) {
                    String newName;
                    boolean ok;
                    do {
                        newName = DataInput.getString("New name for this teacher: ");
                        ok = true;
                        for (int i = 0; i < newName.length(); i++) {
                            if (!(((newName.charAt(i) >= 'a') && (newName.charAt(i) <= 'z')) || ((newName.charAt(i) >= 'A') && (newName.charAt(i) <= 'Z')) || (newName.charAt(i) == ' '))) {
                                ok = false;
                                break;
                            }
                        }
                        if (!ok) System.out.println("Please, type correct name");
                    } while (!ok);

                    if(findIdenticalTeacher(newName)){
                        ArrayActions.printStringCool(" Identical teacher found. Are you sure you want to change this field? \n 1. Yes \n 2. No ", 5);
                        int variant = DataInput.getInt();
                        switch (variant){
                            case 1 -> teachers[option - 1].setName(newName);
                            case 2 -> {}
                            default -> System.out.println("Wrong option");
                        }
                    }else{
                        teachers[option - 1].setName(newName);
                    }


                } else if (option == optionNumber) {
                    here = false;
                } else {
                    System.out.println("Wrong option");
                }
            }
        }
    }

    /**
     * (3) deleteHuman
     *
     * @param who - "student"/"teacher"
     */
    private void deleteHuman(String who) {
        boolean here = true;
        while (here) {
            if (who.equals("student")) {
                StringBuilder outputStr = new StringBuilder("Choose student you want to delete in " + name);
                int optionNumber = 0;
                for (Student student : students) {
                    outputStr.append("\n").append(++optionNumber).append(". ").append(student);
                }
                outputStr.append("\n").append(++optionNumber).append(". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if ((option < optionNumber) && (option > 0)) {
                    students[option - 1].setDeleted(true);
                    Student[] copyArray = new Student[students.length - 1];
                    System.arraycopy(students, 0, copyArray, 0, option - 1);
                    System.arraycopy(students, option, copyArray, option - 1, students.length - option);
                    students = copyArray;
                } else if (option == optionNumber) {
                    here = false;
                } else {
                    System.out.println("Wrong option");
                }
            } else {
                StringBuilder outputStr = new StringBuilder("Choose teacher you want to delete in " + name);
                int optionNumber = 0;
                for (Teacher teacher : teachers) {
                    outputStr.append("\n").append(++optionNumber).append(". ").append(teacher);
                }
                outputStr.append("\n").append(++optionNumber).append(". Back ");
                ArrayActions.printStringCool(outputStr.toString(), 5);
                int option = DataInput.getInt();
                if ((option < optionNumber) && (option > 0)) {
                    teachers[option - 1].setDeleted(true);
                    Teacher[] copyArray = new Teacher[students.length - 1];
                    System.arraycopy(teachers, 0, copyArray, 0, option - 1);
                    System.arraycopy(teachers, option, copyArray, option - 1, teachers.length - option);
                    teachers = copyArray;
                } else if (option == optionNumber) {
                    here = false;
                } else {
                    System.out.println("Wrong option");
                }
            }
        }
    }

    private boolean findIdenticalStudent(String newName, int newCourse, int newGroup) {
        for (Student student : students) {
            if((student.getName().equals(newName))&&(student.getCourse().equals(newCourse))&&(student.getGroup().equals(newGroup))){
                return true;
            }
        }
        return false;
    }

    private boolean findIdenticalTeacher(String newName) {
        for (Teacher teacher:teachers) {
            if(teacher.getName().equals(newName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
