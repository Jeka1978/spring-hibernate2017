package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Evegeny on 21/03/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person(1, "Moshe");
        User user = User.builder().favorite("food").favorite("beer").person(person).build();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        System.out.println("json = " + json);
        User userFromJson = mapper.readValue(json, User.class);
        System.out.println("userFromJson = " + userFromJson);
    }
}
