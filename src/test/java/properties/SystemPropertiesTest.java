package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // null
    }

    @Test
    void simpleProperty1() {
        System.setProperty("browser", "opera"); //key, value
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // opera

        System.setProperty("key", "operaValue"); //key, value
        String browserName1 = System.getProperty("key");
        System.out.println(browserName1); // operaValue
    }

    @Test
    void simplePropertyTest3() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); //
    }

    @Test
    void simpleProperty4() {
        System.setProperty("browser", "opera"); //key, value
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // opera

//        System.setProperty("key", "operaValue"); //key, value
//        String browserName1 = System.getProperty("key");
//        System.out.println(browserName1); // operaValue
    }

    @Test
    @Tag("lego")
    void simplePropertyTest5() {
        String browserName = System.getProperty("browser", "firefox");

        System.out.println(browserName); //

        // .\gradlew clean lego_test


        // .\gradlew clean lego_test -Dbrowser=safari
    }

    @Test
    @Tag("hello")
    void simplePrTest() {
        System.out.println("Hello, " + System.getProperty("user_name", ""));


    }

    /*
    .\gradlew clean hello_test
    Hello, unknown student

    .\gradlew clean hello_test -Duser_name=Leonard
    Hello, Leonard

    .\gradlew clean hello_test -Duser_name="Leonard Liff"
    Hello, Leonard Liff


*/
}
