package org.apache.commons.collections4.functors;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Closure;

public class ForClosure_execute_1_0_Test {

    private ForClosure<String> forClosure;

    private Closure<String> mockClosure;

    @BeforeEach
    public void setUp() {
        mockClosure = mock(Closure.class);
        forClosure = new ForClosure<>(3, mockClosure);
    }

    @Test
    public void testExecuteCallsClosureAcceptCorrectNumberOfTimes() {
        String input = "testInput";
        forClosure.execute(input);
        // Verify that the accept method is called 3 times with the input "testInput"
        verify(mockClosure, times(3)).accept(input);
    }

    @Test
    public void testExecuteWithDifferentInput() {
        String input = "anotherInput";
        forClosure.execute(input);
        // Verify that the accept method is called 3 times with the input "anotherInput"
        verify(mockClosure, times(3)).accept(input);
    }

    @Test
    public void testExecuteWithNullInput() {
        forClosure.execute(null);
        // Verify that the accept method is called 3 times with null
        verify(mockClosure, times(3)).accept(null);
    }

    @Test
    public void testExecuteWithZeroCount() {
        ForClosure<String> zeroCountClosure = new ForClosure<>(0, mockClosure);
        zeroCountClosure.execute("testInput");
        // Verify that the accept method is not called
        verify(mockClosure, never()).accept(any());
    }

    @Test
    public void testExecuteWithNegativeCount() {
        ForClosure<String> negativeCountClosure = new ForClosure<>(-1, mockClosure);
        negativeCountClosure.execute("testInput");
        // Verify that the accept method is not called
        verify(mockClosure, never()).accept(any());
    }
}
