package testFormQa.random;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomData {

    public static String randomFirstName() {
        return new Faker(new Locale("en")).name().firstName();
    }

    public static String randomLastName() {
        return new Faker(new Locale("en")).name().lastName();
    }

    public static String randomEmail() {
        return new Faker(new Locale("en")).internet().emailAddress();
    }

    public static String randomPhone() {
        String phone = "7" + new Faker(new Locale("en")).phoneNumber().subscriberNumber(9);
        return phone;
    }

    public static String invalidPhone() {
        String phone = "7" + new Faker(new Locale("en")).phoneNumber().subscriberNumber(4);
        return phone;
    }

    public static String randomAddress() {
        return new Faker(new Locale("en")).address().fullAddress();
    }
    public static Integer randomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static void main(String[] args) {
        System.out.println(randomPhone());
    }

}
