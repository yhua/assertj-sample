package feature;

import model.TestDataModel;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ExceptionAssertTest {

    @Test
    public void testExceptionAssertion(){
        List persons = TestDataModel.createPersons();

        try {
            persons.get(9);
            fail("IndexOutOfBoundsException expected because persons has only 9 elements");
        } catch (IndexOutOfBoundsException e) {
            assertThat(e).hasMessage("Index: 9, Size: 5");
        }

        try {
//            persons.get(5);
            persons.get(4);
            failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e).hasMessage("Index: 5, Size: 5");
        }

    }
}
