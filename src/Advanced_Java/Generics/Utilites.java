package Advanced_Java.Generics;

//public class Utilites<K, V> {
//
//    // static methods are not associated to class object so they cant refer to this type K or V
//    public static void doSomething(K key, V value) {
//        System.out.println(key);
//        System.out.println(value);
//    }
//}


public class Utilites {

    // these parameters are needed only for this method and not the entire class level
    public static <K, V> void doSomething(K key, V value) {
        System.out.println(key);
        System.out.println(value);
    }

    public static <K, V> K getFirst(K key, V value) {
        return key;
    }
}