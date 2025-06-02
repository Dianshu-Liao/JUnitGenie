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

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethods() {
        try {
            // Create an instance of the class under test
            SevenZArchiveEntry entry = new SevenZArchiveEntry();

            // Prepare test data
            SevenZMethod method1 = SevenZMethod.LZMA; // Example method
            SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method1); // Use constructor with method
            SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method1); // Use constructor with method
            List<SevenZMethodConfiguration> c1 = Arrays.asList(config1, config2);
            List<SevenZMethodConfiguration> c2 = Arrays.asList(config1, config2);

            // Access the private method using reflection
            Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
            method.setAccessible(true);

            // Test with equal configurations
            boolean result = (boolean) method.invoke(entry, c1, c2);
            assertTrue(result);

            // Test with different configurations
            List<SevenZMethodConfiguration> c3 = Arrays.asList(new SevenZMethodConfiguration(SevenZMethod.LZMA)); // Use constructor with method
            result = (boolean) method.invoke(entry, c1, c3);
            assertFalse(result);

            // Test with null second parameter
            result = (boolean) method.invoke(entry, c1, null);
            assertFalse(result);

            // Test with null first parameter
            result = (boolean) method.invoke(entry, null, c2);
            assertTrue(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}