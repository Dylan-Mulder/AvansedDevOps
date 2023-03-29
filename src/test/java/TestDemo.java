import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDemo {
    @Test
    public void demoTest() {
        assertTrue(true);
    }
}
