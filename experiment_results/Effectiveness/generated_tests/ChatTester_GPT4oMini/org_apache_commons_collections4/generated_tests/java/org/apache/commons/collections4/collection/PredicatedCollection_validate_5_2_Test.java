package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.reflect.Method;
import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
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

class PredicatedCollection_validate_5_2_Test {

    private PredicatedCollection<String> predicatedCollection;

    private Predicate<String> predicate;

    @BeforeEach
    void setUp() {
        // Example predicate: non-null and non-empty strings
        predicate = s -> s != null && !s.isEmpty();
        Collection<String> collection = new ArrayList<>();
        predicatedCollection = new PredicatedCollection<>(collection, new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return predicate.test(object);
            }
        });
    }

    @Test
    void testValidateWithValidObject() {
        // Valid object
        String validObject = "Valid String";
        assertDoesNotThrow(() -> {
            invokeValidate(validObject);
        });
    }

    @Test
    void testValidateWithNullObject() {
        // Invalid object (null)
        String invalidObject = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeValidate(invalidObject);
        });
        assertEquals("Cannot add Object 'null' - Predicate '" + predicate + "' rejected it", exception.getMessage());
    }

    @Test
    void testValidateWithEmptyString() {
        // Invalid object (empty string)
        String invalidObject = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeValidate(invalidObject);
        });
        assertEquals("Cannot add Object '' - Predicate '" + predicate + "' rejected it", exception.getMessage());
    }

    private void invokeValidate(String object) throws Exception {
        // Use reflection to invoke the private validate method
        Method method = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
        method.setAccessible(true);
        method.invoke(predicatedCollection, object);
    }
}
