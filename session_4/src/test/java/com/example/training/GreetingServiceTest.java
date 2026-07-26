package com.example.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    private final GreetingService service = new GreetingService();

    @Test
    void createsGreeting() {
        assertEquals(
                "Hello, Ana!",
                service.greet("Hello", "ana")
        );
    }

    @Test
    void usesDefaultsWhenValuesAreBlank() {
        assertEquals(
                "Hello, Guest!",
                service.greet(" ", "")
        );
    }
}
