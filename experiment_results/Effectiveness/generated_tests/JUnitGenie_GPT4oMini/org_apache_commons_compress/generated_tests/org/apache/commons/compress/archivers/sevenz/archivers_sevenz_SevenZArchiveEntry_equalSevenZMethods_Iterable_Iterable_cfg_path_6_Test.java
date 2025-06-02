package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethods() {
        try {
            // Create an instance of SevenZArchiveEntry
            SevenZArchiveEntry entry = new SevenZArchiveEntry();

            // Prepare test data
            SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid method
            SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid method
            List<SevenZMethodConfiguration> c1 = Arrays.asList(config1);
            List<SevenZMethodConfiguration> c2 = Arrays.asList(config2);

            // Access the private method using reflection
            Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
            method.setAccessible(true);

            // Test case where both lists are equal
            assertTrue((Boolean) method.invoke(entry, c1, c1));

            // Test case where lists are not equal
            assertFalse((Boolean) method.invoke(entry, c1, c2));

            // Test case where first list is null
            assertFalse((Boolean) method.invoke(entry, null, c2));

            // Test case where both lists are null
            assertTrue((Boolean) method.invoke(entry, null, null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}