package feature;

import model.Person;
import org.junit.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomComparisonAssertTest {

    private Comparator<? super Person> ageComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getAge(),o2.getAge());
        }
    };

    @Test
    public void testUserCustomComparison(){
        Person ben = new Person("Alain", 18, "Alain@mail.com");
        Person gandalf = new Person("Gandalf", 18, "Gandalf@mail.com");

        assertThat(ben).isNotEqualTo(gandalf);
        assertThat(ben).usingComparator(ageComparator).isEqualTo(gandalf);

    }
}
