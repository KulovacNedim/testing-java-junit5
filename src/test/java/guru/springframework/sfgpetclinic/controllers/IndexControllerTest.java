package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test Is Right View Returned Index Controller")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertNotEquals("ind", indexController.index(), "Wrong View Returned.");

        assertNotEquals("ind", indexController.index(), () -> "Another expensive message. Build me only if you have to.");
        assertThat(indexController.index()).isEqualTo("index");
    }

    @DisplayName("Test exception")
    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oopsHandler();
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("Testing time out...");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("Testing time out... You can't see me.");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("NEDIM".equalsIgnoreCase(System.getenv("JAVA_HOME")));
    }

    @Test
    void testAssumptionTrueWhenAssumptionIsTrue() {
        assumeTrue("NEDIM".equalsIgnoreCase("nedim"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindowsOS() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Nedim")
    @Test
    void testIfUserNedim() {
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Amela")
    @Test
    void testIfUserAmela() {
    }
}