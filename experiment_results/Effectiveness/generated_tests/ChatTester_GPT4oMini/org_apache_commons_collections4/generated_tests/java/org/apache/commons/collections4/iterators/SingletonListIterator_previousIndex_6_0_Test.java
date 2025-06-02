package org.apache.commons.collections4.iterators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class SingletonListIterator_previousIndex_6_0_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        iterator = new SingletonListIterator<>("test");
    }

    @Test
    public void testPreviousIndex_BeforeFirst() {
        // Test when beforeFirst is true
        assertEquals(-1, iterator.previousIndex());
    }

    @Test
    public void testPreviousIndex_AfterFirst() throws Exception {
        // Use reflection to set beforeFirst to false
        java.lang.reflect.Field beforeFirstField = SingletonListIterator.class.getDeclaredField("beforeFirst");
        beforeFirstField.setAccessible(true);
        beforeFirstField.set(iterator, false);
        // Test when beforeFirst is false
        assertEquals(0, iterator.previousIndex());
    }
}
