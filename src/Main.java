import models.SoftwareProject;

public class Main {
    public static void main(String[] args) {
        var mySfPr = new SoftwareProject(10, "I am tired");
        System.out.println(mySfPr.getName());
    }
}