package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
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

public class PredicatedCollection_validate_5_4_Test {

    private Predicate<Object> predicate;

    private PredicatedCollection<Object> predicatedCollection;

    @BeforeEach
    public void setUp() {
        // Example predicate: only allows non-null objects
        predicate = object -> object != null;
        List<Object> initialCollection = new ArrayList<>();
        predicatedCollection = new PredicatedCollection<>(initialCollection, predicate);
    }

    @Test
    public void testValidateWithValidObject() {
        Object validObject = new Object();
        assertDoesNotThrow(() -> predicatedCollection.validate(validObject));
    }

    @Test
    public void testValidateWithNullObject() {
        Object nullObject = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> predicatedCollection.validate(nullObject));
        assertEquals("Cannot add Object 'null' - Predicate 'null' rejected it", exception.getMessage());
    }

    @Test
    public void testValidateWithInvalidObject() {
        Object invalidObject = new Object() {

            @Override
            public String toString() {
                return "InvalidObject";
            }
        };
        // Update predicate to reject all objects
        predicate = object -> false;
        predicatedCollection = new PredicatedCollection<>(new ArrayList<>(), predicate);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> predicatedCollection.validate(invalidObject));
        assertEquals("Cannot add Object 'InvalidObject' - Predicate 'false' rejected it", exception.getMessage());
    }

    @Test
    public void testValidateWithEmptyCollection() {
        Object validObject = new Object();
        assertDoesNotThrow(() -> predicatedCollection.validate(validObject));
    }
}
