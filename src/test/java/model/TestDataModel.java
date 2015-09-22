package model;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TestDataModel {

    public static List<Person> createPersons(){
        List<Person> persons = newArrayList(
                new Person("Ben", 18, "Ben@mail.com"),
                new Person("Ken", 18, "Ken@mail.com"),
                new Person("Alain", 18, "Alain@mail.com"),
                new Person("Eric", 18, "Eric@mail.com") ,
                new Person("Yifei", 19, "yhua@mail.com")
        );

        return persons;
    }

}
