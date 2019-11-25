package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

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
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is some expensive message to build for my test.");
    }
}