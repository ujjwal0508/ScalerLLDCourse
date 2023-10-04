package Advanced_Java.Collections;

import java.util.*;

public class Client {
    public static void main(String[] args) {

//        PriorityQueue pq = new PriorityQueue();
//
//        pq.add(10);
//        pq.add(54);
//        pq.add(34);
//        pq.add(7);
//
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("ujjwal", 26, 5));
        list.add(new Student("ajeeth", 16, 4));
        list.add(new Student("bharath", 6, 23));
        list.add(new Student("gayatri", 12, 1));

        Collections.sort(list, new StudentAgeComparator());
        System.out.println(list);
    }
}
