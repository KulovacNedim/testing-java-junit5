package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions() {
        Person person = new Person(1L, "Joe", "Buck");

        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe"),
                () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAssertionsMsg() {
        Person person = new Person(1L, "Joe", "Buck");

        assertAll("Test Props Set",
                // broke properties to see failing messages
                () -> assertEquals(person.getFirstName(), "Joe", "First Name Failed"),
                () -> assertEquals(person.getLastName(), "Buck", "Last Name Failed"));
    }
}