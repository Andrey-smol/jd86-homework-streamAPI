import Persons.Education;
import Persons.Person;
import Persons.PersonComparator;
import Persons.Sex;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        //Задача 3: Работа с числами
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        CollectionMain.conversionList(intList);
        StreamMain.conversionList(intList);

        //Задача 4: Перепись населения
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //поиск несовершеннолетних
        System.out.printf("Несовершеннолетних - %d\n", persons.stream().filter(p -> p.getAge() < 18).count());

        //получение списка призывников
        List<String> list = persons.stream().
                filter(p -> p.getAge() >= 18 && p.getAge() < 27).
                map(Person::getFamily).
                collect(Collectors.toList());
        list.stream().limit(100).forEach(s -> {
            count++;
            if (count % 20 == 0) {
                System.out.println();
            }
            System.out.print("  " + s);
        });

        //получение отсортированного по фамилии списка потенциально работоспособных людей с высшим образованием
        List<Person> fl = persons.stream().
                filter(p -> p.getAge() >= 18 && (p.getSex() == Sex.WOMAN && p.getAge() < 60 || p.getSex() == Sex.MAN && p.getAge() < 65)).
                filter(p -> p.getEducation() == Education.HIGHER).sorted(new PersonComparator()).collect(Collectors.toList());
        System.out.print("\n********************************************************************\n");
        fl.stream().limit(20).forEach(System.out::println);
    }
}
