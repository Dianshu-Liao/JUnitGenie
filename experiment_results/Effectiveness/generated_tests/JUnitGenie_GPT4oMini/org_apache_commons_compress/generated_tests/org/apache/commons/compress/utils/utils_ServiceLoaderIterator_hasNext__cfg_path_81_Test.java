package org.apache.commons.compress.utils;
import static org.junit.Assert.assertTrue;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Before;
import org.junit.Test;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_81_Test {
    private ServiceLoaderIterator<Object> serviceLoaderIterator;

    @Before
    public void setUp() {
        serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
    }

    @Test(timeout = 4000)
    public void testHasNextWhenNextServiceLoaderIsNull() {
        // This test case will execute the path where nextServiceLoader is null and
        // serviceLoaderIterator has a next element; it should return true.
        
        boolean result = serviceLoaderIterator.hasNext();
        assertTrue("Expected hasNext() to return true", result);
    }

}