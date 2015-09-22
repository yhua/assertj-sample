package feature;

import model.TestDataModel;
import model.Person;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodCallAssertTest {
    @Test
    public void testMethodCallAssertion() {
        List<Person> persons = TestDataModel.createPersons();
        assertThat(persons).extractingResultOf("getName")
                .contains("Ben", "Ken", "Eric", "Yifei")
                .doesNotContain("Apple", "Orange");
    }
}
