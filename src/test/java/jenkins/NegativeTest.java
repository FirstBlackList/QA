package jenkins;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class NegativeTest {

    @Test
    void test1() {
        assertTrue(false);
    }


}
