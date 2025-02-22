import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionMain {
    static public void conversionList(List<Integer> cl) {
        List<Integer> list = new ArrayList<>();
        for (int n : cl) {
            if (n > 0 && n % 2 == 0) {
                list.add(n);
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
