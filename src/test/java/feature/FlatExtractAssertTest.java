package feature;


import model.Person;
import model.Player;
import org.assertj.core.api.iterable.Extractor;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class FlatExtractAssertTest {
    @Test
    public void testFriends() {
        Player jordan = new Player("jordan");
        Person ben = new Person("Ben", 18, "Ben@mail.com");
        Person ken = new Person("Ken", 18, "Ken@mail.com");
        Person yifei = new Person("yifei", 18, "Ken@mail.com");
        jordan.setFriends(newArrayList(ben, ken));

        Player magic = new Player("magic");
        Person alvin = new Person("Alain", 18, "Alain@mail.com");
        Person eric = new Person("Eric", 18, "Eric@mail.com");
        magic.setFriends(newArrayList(alvin, eric));

        List<Player> reallyGoodFriends = newArrayList(jordan, magic);

        assertThat(reallyGoodFriends).flatExtracting("friends")
                .contains(ben, ken, alvin, eric);

        PlayerFriendsExtractor friendsExtractor = new PlayerFriendsExtractor();
        assertThat(reallyGoodFriends).flatExtracting(friendsExtractor)
                .contains(ben, ken, alvin, eric, yifei);


    }

    public class PlayerFriendsExtractor implements Extractor<Player, List<Person>> {
        @Override
        public List<Person> extract(Player input) {
            return input.getFriends();
        }
    }
}
