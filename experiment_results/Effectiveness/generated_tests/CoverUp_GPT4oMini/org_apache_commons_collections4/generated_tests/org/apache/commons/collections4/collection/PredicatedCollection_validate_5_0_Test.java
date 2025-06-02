package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.set.PredicatedSet;

class PredicatedCollection_validate_5_0_Test {

    private PredicatedCollection<String> predicatedCollection;

    private Predicate<String> predicate;

    @BeforeEach
    void setUp() {
        // Set up a simple predicate that only accepts non-null strings
        predicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return object != null;
            }
        };
        Collection<String> collection = new ArrayList<>();
        predicatedCollection = new PredicatedCollection<>(collection, predicate);
    }

    @Test
    void testValidate_ValidInput() {
        // This should not throw an exception
        assertDoesNotThrow(() -> invokeValidate("Valid String"));
    }

    @Test
    void testValidate_NullInput() {
        // This should throw an IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> invokeValidate(null));
        assertEquals("Cannot add Object 'null' - Predicate '" + predicate + "' rejected it", exception.getMessage());
    }

    @Test
    void testValidate_EmptyStringInput() {
        // This should also throw an IllegalArgumentException if we change the predicate logic
        // For the current predicate, this will pass
        assertDoesNotThrow(() -> invokeValidate(""));
    }

    private void invokeValidate(String input) throws Exception {
        Method validateMethod = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
        validateMethod.setAccessible(true);
        validateMethod.invoke(predicatedCollection, input);
    }
}
