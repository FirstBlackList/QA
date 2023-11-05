package jenkins;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SkippedTest {

    @Test
    @Disabled("Some reason")
    void test1() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void test2() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void test3() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void test4() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void test5() {
        assertTrue(false);
    }

}
