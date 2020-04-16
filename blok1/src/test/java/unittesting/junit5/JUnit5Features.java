package unittesting.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class JUnit5Features {

    @BeforeAll
    static void beforeAll() { }

    @AfterAll
    static void afterAll() { }

    @BeforeEach
    void setUp() { }

    @AfterEach
    void tearDown() { }

    @Test
    void exitIfFalseIsTrue() {
        assumeTrue(false);
        System.exit(1);
    }

    @Test
    @Disabled("Y U No Pass?!")
    void failingTest() {
        assertTrue(false);
    }

    @DisabledOnJre(JRE.JAVA_8)
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "JUnit"})
    void withValueSource(String word) {
        assertNotNull(word);
    }

    @ParameterizedTest
    @MethodSource("createWords")
    void withMethodSource(String word) {
        assertNotNull(word);
    }

    private static Stream<String> createWords() {
        return Stream.of("Hello", "Junit");
    }

    @ParameterizedTest
    @CsvSource({"Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15"})
    void withCsvSource(String word, int length) { }
}
