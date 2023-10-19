package DesignPattern.PrototypeAndRegistry;

public class Client {
    public static void main(String[] args) {

        StudentRegistry studentRegistry = new StudentRegistry();
        fillStudentRegistry(studentRegistry); // AT BOOT TIME

        Student st = studentRegistry.get("apr21Student").clone();
        st.setName("ujjwal");
        st.setPsp(100);
        st.setAge(26);

        Student intelliStud = studentRegistry.get("apr21IntelligentStudent").clone();
        intelliStud.setName("ujjwal again");

        System.out.println("DEBUG");
    }

    public static void fillStudentRegistry(StudentRegistry registry){

        Student aprStudent = new Student();
        aprStudent.setBatchPsp(45);
        aprStudent.setBatchName("apr21");
        registry.register("apr21Student", aprStudent);

        IntelligentStudent aprIntelligentStud = new IntelligentStudent();
        aprIntelligentStud.setBatchPsp(82);
        aprIntelligentStud.setBatchName("apr21Intelligent");

        registry.register("apr21IntelligentStudent", aprIntelligentStud);
    }
}
