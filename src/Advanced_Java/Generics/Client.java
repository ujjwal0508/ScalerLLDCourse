package Advanced_Java.Generics;

import java.util.HashMap;
import java.util.List;

public class Client {
    public static void main(String[] args) {

//        HashMap<Integer, String> hm = new HashMap<>();

        //type erasure
//        System.out.println(hm.getClass().getName());


//        hm.put(1, "Ujj");
//        hm.put("jin", "ujj");

        HashMap hm = new HashMap();
        hm.put(1, "Ujj");
        hm.put("ujj", 1);

        for (var v : hm.keySet()) {
            int i = (Integer) v;
            System.out.println(i);
        }

//        List

//        Utilites utilites = new Utilites();

        // show type from object to string here
        Utilites.doSomething("abc", "def");

        // not allowed as returns type of first which is string
//        int val = utilites.getFirst("abc", "def");

        int val = Utilites.getFirst(1, "abc");

        // allowed as type as method level not at class level
        Utilites.getFirst("abc", 1);
    }
}
