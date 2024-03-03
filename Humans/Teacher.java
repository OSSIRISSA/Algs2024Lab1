package Humans;

public class Teacher extends Human{

    public Teacher(String name){
        super(name);
    }

    @Override
    public String toString() {
        return super.toString()+(!isDeleted ? ("\n") : "");
    }
}
