package feature;

import model.Person;
import model.TestDataModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ExpectedPropertiesAssertTest {


    @Test
    public  void testPropertyName() {
        List<Person> persons = TestDataModel.createPersons();

        // traditional way
        List<String> names = new ArrayList<String>();
        for (Person person : persons) {
            names.add(person.getName());
        }
        assertThat(names).contains("Ben", "Ken", "Eric", "Alain");

        // with AssertJ
        assertThat(persons).extracting("name")
                .contains("Ben", "Ken", "Eric", "Alain")
                .doesNotContain("Apple", "Orange");

        // traditional way

        for (Person person : persons) {
            // iterate all the value , and verify with expected value.
        }

        // with AssertJ
        assertThat(persons).extracting("name", "age", "email")
                .contains(tuple("Ben", 18, "Ben@mail.com"),
                        tuple("Alain", 18, "Alain@mail.com"),
                        tuple("Ken", 18, "Ken@mail.com"));

        assertThat(extractProperty("age", Integer.class).from(persons)).contains(18);

    }

}
