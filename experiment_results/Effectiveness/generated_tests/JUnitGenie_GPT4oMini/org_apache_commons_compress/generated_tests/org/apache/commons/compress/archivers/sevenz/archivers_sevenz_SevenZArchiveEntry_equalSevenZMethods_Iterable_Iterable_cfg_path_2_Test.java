package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethodsBothNull() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        
        boolean result = (boolean) method.invoke(entry, null, null);
        assertTrue(result);
    }






}
