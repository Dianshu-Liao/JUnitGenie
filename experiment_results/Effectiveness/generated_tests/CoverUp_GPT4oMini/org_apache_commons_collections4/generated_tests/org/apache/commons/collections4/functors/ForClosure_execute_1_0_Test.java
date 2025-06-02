package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class ForClosure_execute_1_0_Test {

    private ForClosure<String> forClosure;

    private Closure<String> mockClosure;

    @BeforeEach
    public void setUp() {
        mockClosure = mock(Closure.class);
        // Initialize with count 3
        forClosure = new ForClosure<>(3, mockClosure);
    }

    @Test
    public void testExecuteCallsClosureCorrectNumberOfTimes() {
        String input = "testInput";
        forClosure.execute(input);
        // Verify that the closure's accept method is called three times
        verify(mockClosure, times(3)).accept(input);
    }

    @Test
    public void testExecuteWithDifferentInput() {
        String input1 = "input1";
        String input2 = "input2";
        forClosure.execute(input1);
        forClosure.execute(input2);
        // Verify that the closure's accept method is called for each input
        verify(mockClosure, times(3)).accept(input1);
        verify(mockClosure, times(3)).accept(input2);
    }

    @Test
    public void testGetCount() {
        assertEquals(3, forClosure.getCount());
    }

    @Test
    public void testGetClosure() {
        assertNotNull(forClosure.getClosure());
        assertSame(mockClosure, forClosure.getClosure());
    }
}
