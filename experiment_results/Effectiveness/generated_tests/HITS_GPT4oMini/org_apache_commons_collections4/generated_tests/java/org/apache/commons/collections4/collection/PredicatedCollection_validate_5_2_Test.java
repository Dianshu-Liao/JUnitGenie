package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
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

public class PredicatedCollection_validate_5_2_Test {

    private Predicate<Object> predicate;

    private PredicatedCollection<Object> predicatedCollection;

    @BeforeEach
    public void setUp() {
        // Create a simple predicate that only accepts non-null objects
        predicate = object -> object != null;
        Collection<Object> collection = new ArrayList<>();
        predicatedCollection = new PredicatedCollection<>(collection, predicate);
    }

    @Test
    public void testValidate_WithValidObject() {
        // This should not throw an exception
        assertDoesNotThrow(() -> predicatedCollection.validate(new Object()));
    }

    @Test
    public void testValidate_WithNullObject() {
        // This should throw an IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedCollection.validate(null);
        });
        assertEquals("Cannot add Object 'null' - Predicate 'org.apache.commons.collections4.functors.NotNullPredicate@<hashcode>' rejected it", exception.getMessage());
    }

    @Test
    public void testValidate_WithInvalidObject() {
        // Create a predicate that only accepts even integers
        Predicate<Object> evenPredicate = object -> object instanceof Integer && (Integer) object % 2 == 0;
        Collection<Object> collection = new ArrayList<>();
        predicatedCollection = new PredicatedCollection<>(collection, evenPredicate);
        // This should throw an IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedCollection.validate(3);
        });
        assertEquals("Cannot add Object '3' - Predicate 'org.apache.commons.collections4.functors.Predicate@<hashcode>' rejected it", exception.getMessage());
    }

    @Test
    public void testValidate_WithValidEvenObject() {
        // This should not throw an exception
        assertDoesNotThrow(() -> {
            predicatedCollection.validate(4);
        });
    }
}
