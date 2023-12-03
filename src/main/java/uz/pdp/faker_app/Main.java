package uz.pdp.faker_app;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.github.javafaker.Name;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Faker faker=new Faker(Locale.forLanguageTag("ru"));
        Name name = faker.name();
        System.out.println(faker.phoneNumber().cellPhone());
        Lorem lorem = faker.lorem();




    }
}