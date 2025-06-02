package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.LoopingListIterator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.Assert.fail;

public class iterators_LoopingListIterator_previousIndex__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPreviousIndexThrowsNoSuchElementExceptionWhenListIsEmpty() {
        List<Object> emptyList = new ArrayList<>();
        LoopingListIterator<Object> iterator = new LoopingListIterator<>(emptyList);
        
        try {
            iterator.previousIndex();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Exception is expected, test passes
        }
    }

}