package feature;

import model.Person;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

public class FilterObjectsAssertTest {
    @Test
    public void testFilerObjectsAssertion() {
        Person ben = new Person("Ben", 18, "ben@mail.com");
        Person ken = new Person("Ken", 18, "ken@mail.com");
        Person alvin = new Person("Alain", 18, "alvin@mail.com");
        Person eric = new Person("Eric", 18, "eric@mail.com");
        Person yifei = new Person("Yifei", 19, "yhua@mail.com");
        Person nick = new Person("Nick", 17, "nick@mail.com");


        List<Person> persons = newArrayList(ben, ken, alvin, eric, yifei, nick);
        assertThat(filter(persons).with("age").equalsTo(18).get())
                .containsOnly(ben, ken, alvin, eric);

        assertThat(filter(persons).with("age", 18).get())
                .containsOnly(ben, ken, alvin, eric);


        assertThat(filter(persons).with("age").notIn(18, 19).get()).containsOnly(nick);
        assertThat(filter(persons).with("age").notEqualsTo(18).get()).contains(yifei, nick);

        assertThat(filter(persons).with("age").equalsTo(18).and("name").notEqualsTo("Ben").get())
                .contains(ken, alvin, eric);
    }
}
