package DesignPattern.PrototypeAndRegistry;

public class Student implements Prototype<Student>{

    private String name;
    private int age;
    private String batchName;
    private double psp;
    private double batchPsp;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public void setBatchPsp(double batchPsp) {
        this.batchPsp = batchPsp;
    }

    Student(){

    }

    Student(Student other){
        this.name = other.name;
        this.batchName = other.batchName;
        this.age = other.age;
        this.batchPsp = other.batchPsp;
        this.psp = other.psp;
    }

    @Override
    public Student clone() {
        Student st = new Student(this);
        return st;
    }
}
