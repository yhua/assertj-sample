import model.Person;
import org.junit.Test;

public class PersonAssertTest {

    @Test
    public void testCustomAssertion() {
        Person yifei = new Person("yifei", 18, "Yifei@mail.com");
        PersonAssert.assertThat(yifei).hasName("yifei").hasAge(18);
    }
}
