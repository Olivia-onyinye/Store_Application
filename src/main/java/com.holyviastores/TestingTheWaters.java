package com.holyviastores;

import com.holyviastores.enums.Gender;
import com.holyviastores.model.Customer;
import com.holyviastores.model.Manager;
import com.holyviastores.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestingTheWaters {

    public static void main(String[] args) {
        List<Person> people = List.of(new Manager(1201, "Marcel", "mary", 23467l, Gender.MALE, "gfbcnsjh"),
                new Manager(1202, "Oat", "Joseph", 23467l, Gender.MALE, "gfbcnsjh"),
                new Manager(1203, "Car", "Mark", 23467l, Gender.FEMALE, "gfbcnsjh"),
                new Manager(1204, "Theo", "April", 23467l, Gender.FEMALE, "gfbcnsjh")
        );
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.FEMALE.equals(person.getGender())) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        //Declarative approach
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
                females2.forEach(System.out::println);
    }
}

