package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.attribute.FileTime;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;

class SevenZArchiveEntry_equalSevenZMethods_3_3_Test {

    @Test
    void testEqualSevenZMethods_NullInputs() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(entry, null, null));
        assertFalse((Boolean) method.invoke(entry, null, Collections.emptyList()));
        assertFalse((Boolean) method.invoke(entry, Collections.emptyList(), null));
    }

    @Test
    void testEqualSevenZMethods_EmptyIterables() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(entry, Collections.emptyList(), Collections.emptyList()));
    }

    @Test
    void testEqualSevenZMethods_DifferentSizes() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        List<SevenZMethodConfiguration> list1 = Arrays.asList(new SevenZMethodConfiguration(SevenZMethod.values()[0]), new SevenZMethodConfiguration(SevenZMethod.values()[1]));
        List<SevenZMethodConfiguration> list2 = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.values()[0]));
        assertFalse((Boolean) method.invoke(entry, list1, list2));
    }

    @Test
    void testEqualSevenZMethods_DifferentContents() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        List<SevenZMethodConfiguration> list1 = Arrays.asList(new SevenZMethodConfiguration(SevenZMethod.values()[0]), new SevenZMethodConfiguration(SevenZMethod.values()[1]));
        List<SevenZMethodConfiguration> list2 = Arrays.asList(new SevenZMethodConfiguration(SevenZMethod.values()[0]), new SevenZMethodConfiguration(SevenZMethod.values()[2]));
        assertFalse((Boolean) method.invoke(entry, list1, list2));
    }

    @Test
    void testEqualSevenZMethods_SameContents() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        List<SevenZMethodConfiguration> list1 = Arrays.asList(new SevenZMethodConfiguration(SevenZMethod.values()[0]), new SevenZMethodConfiguration(SevenZMethod.values()[1]));
        List<SevenZMethodConfiguration> list2 = Arrays.asList(new SevenZMethodConfiguration(SevenZMethod.values()[0]), new SevenZMethodConfiguration(SevenZMethod.values()[1]));
        assertTrue((Boolean) method.invoke(entry, list1, list2));
    }
}
