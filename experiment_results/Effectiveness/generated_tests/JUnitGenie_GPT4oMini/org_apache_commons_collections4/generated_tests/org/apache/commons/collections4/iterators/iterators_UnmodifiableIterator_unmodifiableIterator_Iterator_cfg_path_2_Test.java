package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class iterators_UnmodifiableIterator_unmodifiableIterator_Iterator_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableIterator_withNonUnmodifiable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        
        try {
            Iterator<Integer> result = UnmodifiableIterator.unmodifiableIterator(iterator);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testUnmodifiableIterator_withUnmodifiable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        
        try {
            // Wrapping iterator in an Unmodifiable way for this test
            Iterator<Integer> unmodifiableIterator = UnmodifiableIterator.unmodifiableIterator(iterator);
            Iterator<Integer> result = UnmodifiableIterator.unmodifiableIterator(unmodifiableIterator);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}