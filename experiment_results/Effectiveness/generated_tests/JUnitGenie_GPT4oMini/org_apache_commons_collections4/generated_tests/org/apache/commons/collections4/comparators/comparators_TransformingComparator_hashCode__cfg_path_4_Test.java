package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Comparator;

public class comparators_TransformingComparator_hashCode__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullFields() {
        TransformingComparator<Object, Object> comparator = new TransformingComparator<>(null);
        int expectedHashCode = 17 * 37; // since both decorated and transformer are null
        assertEquals(expectedHashCode, comparator.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullFields() {
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return input;
            }
        };
        TransformingComparator<Object, Object> comparator = new TransformingComparator<>(transformer, null);
        int expectedHashCode = (17 * 37) + (transformer.hashCode());
        assertEquals(expectedHashCode, comparator.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeWithBothFields() {
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return input;
            }
        };
        Comparator<Object> decorated = (o1, o2) -> 0; // Dummy comparator
        TransformingComparator<Object, Object> comparator = new TransformingComparator<>(transformer, decorated);
        int expectedHashCode = (17 * 37) + (decorated.hashCode());
        expectedHashCode = (expectedHashCode * 37) + (transformer.hashCode());
        assertEquals(expectedHashCode, comparator.hashCode());
    }


}