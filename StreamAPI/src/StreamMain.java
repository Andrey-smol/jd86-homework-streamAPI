import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    static public void conversionList(List<Integer> cl) {
        cl.stream().filter(n -> n > 0 && n % 2 == 0).sorted().forEach(System.out::println);
        System.out.println(cl.stream().filter(n -> n > 0 && n % 2 == 0).sorted().collect(Collectors.toList()));
    }
}
