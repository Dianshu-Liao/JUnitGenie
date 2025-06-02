package org.apache.commons.collections4.bloomfilter;

// Fixed import statement
import java.util.function.LongPredicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.LongPredicate;

class CountingLongPredicate_processRemaining_0_2_Test {

    private CountingLongPredicate countingLongPredicate;

    @BeforeEach
    void setUp() {
        long[] ary = { 1L, 2L, 3L, 4L };
        // Predicate that checks if the value is greater than 0
        LongBiPredicate func = (value, zero) -> value > 0;
        countingLongPredicate = new CountingLongPredicate(ary, func);
    }

    @Test
    void testProcessRemaining_AllElementsPass() throws Exception {
        // Set idx to 0, all elements should pass the predicate
        setPrivateField("idx", 0);
        assertTrue(invokeProcessRemaining());
    }

    @Test
    void testProcessRemaining_SomeElementsFail() throws Exception {
        // Set idx to 2, only the last element should fail the predicate
        setPrivateField("idx", 2);
        // Change predicate to fail for value 4
        LongBiPredicate func = (value, zero) -> value < 4;
        setPrivateField("func", func);
        assertFalse(invokeProcessRemaining());
    }

    @Test
    void testProcessRemaining_EmptyArray() throws Exception {
        // Test with an empty array
        long[] emptyArray = {};
        setPrivateField("ary", emptyArray);
        setPrivateField("idx", 0);
        assertTrue(invokeProcessRemaining());
    }

    @Test
    void testProcessRemaining_AllElementsFail() throws Exception {
        // Set idx to 0, all elements should fail the predicate
        setPrivateField("idx", 0);
        // Predicate that checks if the value is less than 0
        LongBiPredicate func = (value, zero) -> value < 0;
        setPrivateField("func", func);
        assertFalse(invokeProcessRemaining());
    }

    private boolean invokeProcessRemaining() throws Exception {
        return (boolean) CountingLongPredicate.class.getDeclaredMethod("processRemaining").invoke(countingLongPredicate);
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = CountingLongPredicate.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(countingLongPredicate, value);
    }
}
