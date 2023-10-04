package Advanced_Java.StreamsAndLambdas.StreamAPIs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream = list.stream();

//        List<Integer> ans = stream.filter((ele) -> ele % 2 == 0)
//                        .collect(Collectors.toList());

//        List<Integer> ans = stream.filter((ele) -> ele % 2 == 0)
//                .sorted()
//                .map((ele) -> ele * 10)
//                .collect(Collectors.toList());

        Optional<Integer> first  = stream.filter((ele) -> ele % 2 == 0)
                .sorted()
                .map((ele) -> ele * 10)
                .findFirst();

        if(first.isPresent())
            System.out.println(first.get());


//        System.out.println(ans);

        // Intermediate operations => filter(), map(), sorted()
        // Terminal operations => count(), foreach() , findfirst()
    }
}
