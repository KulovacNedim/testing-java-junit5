package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutPutter(TestInfo testInfo) {
        System.out.println("Running before each test - " + testInfo.getDisplayName());
    }
}
