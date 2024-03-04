package Humans;

public class Teacher extends Human{
    /**
     * Constructor
     *
     * @param name  - Name of the teacher
     */
    public Teacher(String name){
        super(name);
    }

    @Override
    public String toString() {
        return super.toString()+(!isDeleted ? ("\n") : "");
    }
}
