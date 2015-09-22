package model;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Player {
    private final String name;
    private List<Person> friends = newArrayList();

    public Player(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
}
