import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Задача 3: Работа с числами
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        CollectionMain.conversionList(intList);
        StreamMain.conversionList(intList);


    }
}