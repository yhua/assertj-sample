package feature;

import model.Mansion;
import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectErrorsSoftAssertTest {
    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void host_dinner_party_where_nobody_dies() {
        Mansion mansion = new Mansion();
        mansion.hostPotentiallyMurderousDinnerParty();
        assertThat(mansion.guests()).as("Living Guests").isEqualTo(7);
        assertThat(mansion.kitchen()).as("Kitchen").isEqualTo("clean");
        assertThat(mansion.library()).as("Library").isEqualTo("clean");
        assertThat(mansion.revolverAmmo()).as("Revolver Ammo").isEqualTo(6);
        assertThat(mansion.candlestick()).as("Candlestick").isEqualTo("pristine");
        assertThat(mansion.colonel()).as("Colonel").isEqualTo("well kempt");
        assertThat(mansion.professor()).as("Professor").isEqualTo("well kempt");
    }

    @Test
    public void host_dinner_party_where_nobody_dies2() {
        Mansion mansion = new Mansion();
        mansion.hostPotentiallyMurderousDinnerParty();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(mansion.guests()).as("Living Guests").isEqualTo(7);
        softly.assertThat(mansion.kitchen()).as("Kitchen").isEqualTo("clean");
        softly.assertThat(mansion.library()).as("Library").isEqualTo("clean");
        softly.assertThat(mansion.revolverAmmo()).as("Revolver Ammo").isEqualTo(6);
        softly.assertThat(mansion.candlestick()).as("Candlestick").isEqualTo("pristine");
        softly.assertThat(mansion.colonel()).as("Colonel").isEqualTo("well kempt");
        softly.assertThat(mansion.professor()).as("Professor").isEqualTo("well kempt");
        softly.assertAll();
    }

    @Test
    public void host_dinner_party_where_nobody_dies3() {
        Mansion mansion = new Mansion();
        mansion.hostPotentiallyMurderousDinnerParty();
        softly.assertThat(mansion.guests()).as("Living Guests").isEqualTo(7);
        softly.assertThat(mansion.kitchen()).as("Kitchen").isEqualTo("clean");
        softly.assertThat(mansion.library()).as("Library").isEqualTo("clean");
        softly.assertThat(mansion.revolverAmmo()).as("Revolver Ammo").isEqualTo(6);
        softly.assertThat(mansion.candlestick()).as("Candlestick").isEqualTo("pristine");
        softly.assertThat(mansion.colonel()).as("Colonel").isEqualTo("well kempt");
        softly.assertThat(mansion.professor()).as("Professor").isEqualTo("well kempt");
    }
}
