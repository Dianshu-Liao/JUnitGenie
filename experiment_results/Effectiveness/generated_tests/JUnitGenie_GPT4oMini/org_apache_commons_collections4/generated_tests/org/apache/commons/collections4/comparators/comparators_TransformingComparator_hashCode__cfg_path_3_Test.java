package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Comparator;

public class comparators_TransformingComparator_hashCode__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullDecoratedAndTransformer() {
        TransformingComparator<Object, Object> comparator = new TransformingComparator<>(null, null);
        int expectedHashCode = 17 * 37; // total = 17 * 37 + 0 + 0
        assertEquals(expectedHashCode, comparator.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullDecoratedAndNullTransformer() {
        Comparator<Object> decorated = (o1, o2) -> 0; // Dummy comparator
        TransformingComparator<Object, Object> comparator = new TransformingComparator<>(null, decorated);
        int expectedHashCode = (17 * 37) + decorated.hashCode(); // total = 17 * 37 + decorated.hashCode() + 0
        assertEquals(expectedHashCode, comparator.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullDecoratedAndNonNullTransformer() {
        Transformer<Object, Object> transformer = o -> o; // Dummy transformer
        TransformingComparator<Object, Object> comparator = new TransformingComparator<>(transformer, null);
        int expectedHashCode = (17 * 37) + transformer.hashCode(); // total = 17 * 37 + 0 + transformer.hashCode()
        assertEquals(expectedHashCode, comparator.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullDecoratedAndNonNullTransformer() {
        Comparator<Object> decorated = (o1, o2) -> 0; // Dummy comparator
        Transformer<Object, Object> transformer = o -> o; // Dummy transformer
        TransformingComparator<Object, Object> comparator = new TransformingComparator<>(transformer, decorated);
        int expectedHashCode = (17 * 37) + decorated.hashCode() + transformer.hashCode(); // total = 17 * 37 + decorated.hashCode() + transformer.hashCode()
        assertEquals(expectedHashCode, comparator.hashCode());
    }


}