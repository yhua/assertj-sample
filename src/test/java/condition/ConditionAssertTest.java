package condition;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Sets.newLinkedHashSet;

public class ConditionAssertTest {
    private final Condition<String> fruitStandard = new Condition<String>("fruitStandard") {
        private final Set<String> fruits = newLinkedHashSet("Apple", "Peach", "Raisin");

        @Override
        public boolean matches(String value) {
            return fruits.contains(value);
        }
    };

    private final Condition appleStandard = new Condition<List<String>>("appleStandard") {
        private final String apple = "Apple";

        @Override
        public boolean matches(List<String> values) {
            return values.contains(apple);
        }
    };


    @Test
    public void testConditionAssertion() {
        assertThat("Apple").is(fruitStandard);
        assertThat("Cat").isNot(fruitStandard);

        List<String> fruits = newArrayList("Apple", "Peach", "Raisin");

        assertThat(fruits).has(appleStandard);
        assertThat(fruits).doesNotHave(appleStandard);


        assertThat(newLinkedHashSet("Apple", "Peach")).are(fruitStandard);
        assertThat(newLinkedHashSet("Pear", "Avocat")).areNot(fruitStandard);

        assertThat(newLinkedHashSet("Apple", "Raisin", "Leia")).areAtLeast(2, fruitStandard);
        assertThat(newLinkedHashSet("Apple", "Raisin", "Leia")).areAtMost(2, fruitStandard);
        assertThat(newLinkedHashSet("Apple", "Raisin", "Leia")).areExactly(2, fruitStandard);
    }

}
