package Advanced_Java.Collections;

public class Student implements Comparable<Student> {

    String name;
    int age;
    int rollno;

    Student(String name, int age, int rollno){
        this.name = name;
        this.age = age;
        this.rollno = rollno;
    }


    @Override
    public int compareTo(Student other) {
        // comparison is between this vs other
        // return 0 if both are equal
        // return -1 if i am smaller
        // return 1 if i am greater
        if( this.rollno == other.rollno)
            return 0;
        else if(this.rollno < other.rollno)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.rollno + " - " + this.age;
    }
}
