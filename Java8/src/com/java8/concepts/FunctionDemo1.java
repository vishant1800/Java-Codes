package com.java8.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo1 {
    Function<String, String> subString = str -> str.substring(0,3);
    Function<List<User>, List<User>> startsWithVipAsPrefix = li -> {
        List<User> UserListWithPrefix = new ArrayList<>();
        for(User u : li) {
            if(subString.apply(u.getName()).equalsIgnoreCase("vip")){
                UserListWithPrefix.add(u);
            }
        }
        return UserListWithPrefix;
    };


    User u1 = new User(1, "Vipul");
    User u2 = new User(2, "Vipin");
    User u3 = new User(3, "Vishant");
    User u4 = new User(4, "Ravi");

    List<User> users = Arrays.asList(u1, u2, u3, u4);

}

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
