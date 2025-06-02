package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethods() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();

        // Prepare test data
        // Assuming there is a method to get a default configuration in SevenZMethod
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid constant
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid constant
        List<SevenZMethodConfiguration> c1 = Arrays.asList(config1, config2);
        List<SevenZMethodConfiguration> c2 = Arrays.asList(config1, config2);

        // Access the private method using reflection
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);

        // Test case where both lists are equal
        boolean result = (Boolean) method.invoke(entry, c1, c2);
        assertTrue(result);

        // Test case where the second list is null
        result = (Boolean) method.invoke(entry, c1, null);
        assertFalse(result);

        // Test case where the first list is null
        result = (Boolean) method.invoke(entry, null, c2);
        assertFalse(result);

        // Test case where lists have different sizes
        List<SevenZMethodConfiguration> c3 = Arrays.asList(config1);
        result = (Boolean) method.invoke(entry, c1, c3);
        assertFalse(result);

        // Test case where lists have different elements
        SevenZMethodConfiguration config3 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid constant
        List<SevenZMethodConfiguration> c4 = Arrays.asList(config1, config3);
        result = (Boolean) method.invoke(entry, c1, c4);
        assertFalse(result);
    }

}