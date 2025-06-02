package org.apache.commons.compress.utils;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_9_Test {
    private ServiceLoaderIterator<String> serviceLoaderIterator;


    @Test(timeout = 4000)
    public void testHasNextWithElements() {
        assertTrue(serviceLoaderIterator.hasNext()); // should return true
        serviceLoaderIterator.next(); // Move to the next element
        assertTrue(serviceLoaderIterator.hasNext()); // should still return true
        serviceLoaderIterator.next(); // Move to the next element
        assertFalse(serviceLoaderIterator.hasNext()); // should return false now
    }

}
