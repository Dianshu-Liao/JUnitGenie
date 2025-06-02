package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class iterators_ListIteratorWrapper_previousIndex__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPreviousIndexWhenIteratorIsListIterator() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        ListIterator<Integer> listIterator = list.listIterator(1); // Initialize at index 1 (element = 2)
        ListIteratorWrapper<Integer> listIteratorWrapper = new ListIteratorWrapper<>(listIterator);
        
        // Use reflection to set the private currentIndex field
        try {
            java.lang.reflect.Field field = ListIteratorWrapper.class.getDeclaredField("currentIndex");
            field.setAccessible(true);
            field.setInt(listIteratorWrapper, 1); // Set currentIndex to 1

            int index = listIteratorWrapper.previousIndex();
            assertEquals(0, index);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testPreviousIndexWhenIteratorIsNotListIterator() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        ListIteratorWrapper<Integer> listIteratorWrapper = new ListIteratorWrapper<>(iterator);
        
        // Use reflection to set the private currentIndex field
        try {
            java.lang.reflect.Field field = ListIteratorWrapper.class.getDeclaredField("currentIndex");
            field.setAccessible(true);
            field.setInt(listIteratorWrapper, 1); // Set currentIndex to 1

            int index = listIteratorWrapper.previousIndex();
            assertEquals(0, index); // Since currentIndex is 1, previousIndex should be 0
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}