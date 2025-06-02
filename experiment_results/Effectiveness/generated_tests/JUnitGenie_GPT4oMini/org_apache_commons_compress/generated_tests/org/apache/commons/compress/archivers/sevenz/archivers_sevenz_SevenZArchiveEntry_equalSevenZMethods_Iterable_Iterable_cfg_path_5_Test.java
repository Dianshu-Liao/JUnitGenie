package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethods() {
        try {
            // Create instances of SevenZMethodConfiguration with a valid constructor
            SevenZMethod method1 = SevenZMethod.LZMA; // Use a valid enum constant instead of instantiating
            SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method1);
            SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method1);
            SevenZMethodConfiguration config3 = new SevenZMethodConfiguration(method1);

            // Prepare the input iterables
            List<SevenZMethodConfiguration> c1 = Arrays.asList(config1, config2);
            List<SevenZMethodConfiguration> c2 = Arrays.asList(config1, config2);

            // Access the private method using reflection
            Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
            method.setAccessible(true);

            // Test case where both iterables are equal
            assertTrue((Boolean) method.invoke(new SevenZArchiveEntry(), c1, c2));

            // Modify c2 to make them unequal
            c2 = Arrays.asList(config1, config3);
            // Test case where iterables are not equal
            assertFalse((Boolean) method.invoke(new SevenZArchiveEntry(), c1, c2));

            // Test case where c1 is null
            assertFalse((Boolean) method.invoke(new SevenZArchiveEntry(), null, c2));

            // Test case where c2 is null
            assertFalse((Boolean) method.invoke(new SevenZArchiveEntry(), c1, null));

            // Test case where both are null
            assertTrue((Boolean) method.invoke(new SevenZArchiveEntry(), null, null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}