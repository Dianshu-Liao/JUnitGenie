package org.apache.commons.collections4.set;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import java.util.List;
import org.apache.commons.collections4.set.CompositeSet.SetMutator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

@ExtendWith(MockitoExtension.class)
public class CompositeSet_add_0_1_Test {

    private CompositeSet<String> compositeSet;

    @BeforeEach
    public void setUp() {
        compositeSet = new CompositeSet<>();
    }

    @Test
    public void testAddWithoutMutatorThrowsException() {
        // Arrange
        // No mutator is set, as it is null by default
        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> {
            compositeSet.add("test");
        }, "add() is not supported on CompositeSet without a SetMutator strategy");
    }

    @Test
    public void testAddWithMutator() {
        // Arrange
        SetMutator<String> mockMutator = mock(SetMutator.class);
        compositeSet.setMutator(mockMutator);
        when(mockMutator.add(any(CompositeSet.class), anyList(), eq("test"))).thenReturn(true);
        // Act
        boolean result = compositeSet.add("test");
        // Assert
        assertTrue(result);
        verify(mockMutator).add(compositeSet, compositeSet.getSets(), "test");
    }
}
