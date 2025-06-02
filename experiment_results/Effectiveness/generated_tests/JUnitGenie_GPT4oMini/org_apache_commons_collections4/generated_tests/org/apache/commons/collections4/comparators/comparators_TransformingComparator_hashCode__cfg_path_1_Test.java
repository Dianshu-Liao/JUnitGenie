package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.Comparator;

public class comparators_TransformingComparator_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullFields() {
        // Arrange
        Transformer<Object, Object> transformerMock = mock(Transformer.class);
        Comparator<Object> decoratedMock = mock(Comparator.class);
        
        TransformingComparator<Object, Object> comparator = 
            new TransformingComparator<>(transformerMock, decoratedMock);
        
        // Act
        int hashCode = comparator.hashCode();
        
        // Assert
        // Since we are testing for the hashCode, we assume if it returns a non-negative value, 
        // the functionality is working; alternatively, specific mocked values can be asserted.
        assertEquals(hashCode >= 0, true);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullTransformer() {
        // Arrange
        Comparator<Object> decoratedMock = mock(Comparator.class);
        
        TransformingComparator<Object, Object> comparator = 
            new TransformingComparator<>(null, decoratedMock);
        
        // Act
        int hashCode = comparator.hashCode();
        
        // Assert
        assertEquals(hashCode >= 0, true);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullDecorated() {
        // Arrange
        Transformer<Object, Object> transformerMock = mock(Transformer.class);

        TransformingComparator<Object, Object> comparator = 
            new TransformingComparator<>(transformerMock, null);
        
        // Act
        int hashCode = comparator.hashCode();
        
        // Assert
        assertEquals(hashCode >= 0, true);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithBothNulls() {
        // Arrange
        TransformingComparator<Object, Object> comparator = 
            new TransformingComparator<>(null, null);
        
        // Act
        int hashCode = comparator.hashCode();
        
        // Assert
        assertEquals(hashCode, 0);
    }


}