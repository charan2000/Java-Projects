package method.chaining;

class Student {

    String name;
    int grade;

    public Student setName(String name) {
        this.name = name;                   // Returning Student OBJ because chaining can happen only on objects
        return this;
    }

    public Student setGrade (int grade) {
        this.grade = grade;
        return this;
    }

    public void getDetails() {
        System.out.println("Your name is "+this.name+ " and ur from "+this.grade+"th grade");
    }

}

public class MethodChain {

    public static void main(String[] args) {

        Student std = new Student();
        std.setGrade(16).setName("Charan").getDetails();

    }

}
