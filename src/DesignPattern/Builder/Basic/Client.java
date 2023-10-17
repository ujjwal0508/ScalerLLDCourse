package DesignPattern.Builder.Basic;

public class Client {
    public static void main(String[] args) throws Exception{

//        Builder builder = Student.getBuilder();
//        builder.setAge(25);
//        builder.setName("ujjwal");
//        builder.setGradYear(2019);
//
//        Student st = new Student();
//        Student st = builder.build();


        Student st1 = Student.getBuilder() // returning me Builder object
                .setAge(25) // what should setAge return so i can call setName on it?
                .setName("ujjwal")
                .setGradYear(2019)
                .build();


    }

}

