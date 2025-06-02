package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethods() {
        try {
            // Create instances of SevenZMethodConfiguration with a valid constructor
            SevenZMethod method1 = SevenZMethod.LZMA; // Use a valid enum constant
            SevenZMethod method2 = SevenZMethod.BZIP2; // Use another valid enum constant
            SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method1);
            SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method1);
            SevenZMethodConfiguration config3 = new SevenZMethodConfiguration(method2); // Different configuration

            // Prepare the input iterables
            List<SevenZMethodConfiguration> c1 = new ArrayList<>();
            c1.add(config1);
            c1.add(config2);

            List<SevenZMethodConfiguration> c2 = new ArrayList<>();
            c2.add(config1);
            c2.add(config2);

            List<SevenZMethodConfiguration> c3 = new ArrayList<>();
            c3.add(config3); // Different configuration

            // Access the private method using reflection
            Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
            method.setAccessible(true);

            // Test case where both iterables are equal
            assertTrue((Boolean) method.invoke(new SevenZArchiveEntry(), c1, c2));

            // Test case where iterables are not equal
            assertFalse((Boolean) method.invoke(new SevenZArchiveEntry(), c1, c3));

            // Test case where first iterable is null
            assertFalse((Boolean) method.invoke(new SevenZArchiveEntry(), null, c2));

            // Test case where second iterable is null
            assertFalse((Boolean) method.invoke(new SevenZArchiveEntry(), c1, null));

            // Test case where both iterables are null
            assertTrue((Boolean) method.invoke(new SevenZArchiveEntry(), null, null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}