package utility;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomData {

    final Faker faker = new Faker(new Locale("en-US"));

    public String firstName() {
        return "Test_" + faker.name().firstName();
    }

    public String lastName() {
        return "Test_" + faker.name().lastName();
    }

    public String email() {
        return "test_" + faker.name().username() + "@mailinator.com";
    }

    public String company() {
        return "Test_" + faker.company().name();
    }

    public String password() {
        return faker.internet().password(true);
    }

    public String address() {
        return faker.random().nextInt(100, 999).toString();
    }

    public String phoneNumber() {
        return faker.phoneNumber().cellPhone();
    }
}
