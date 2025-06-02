package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethodsBothNull() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        
        boolean result = (boolean) method.invoke(entry, null, null);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testEqualSevenZMethodsFirstNull() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        boolean result = (boolean) method.invoke(entry, null, Arrays.asList(config));
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualSevenZMethodsSecondNull() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        boolean result = (boolean) method.invoke(entry, Arrays.asList(config), null);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualSevenZMethodsDifferentSizes() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        boolean result = (boolean) method.invoke(entry, Arrays.asList(config1, config2), 
                                                  Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA)));
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualSevenZMethodsEqual() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        boolean result = (boolean) method.invoke(entry, Collections.singletonList(config), Collections.singletonList(config));
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testEqualSevenZMethodsNotEqual() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum constant
        boolean result = (boolean) method.invoke(entry, Collections.singletonList(config1), Collections.singletonList(config2));
        assertFalse(result);
    }


}