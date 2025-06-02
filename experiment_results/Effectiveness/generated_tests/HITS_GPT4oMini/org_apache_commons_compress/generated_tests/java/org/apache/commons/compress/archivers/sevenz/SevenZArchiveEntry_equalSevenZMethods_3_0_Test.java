package org.apache.commons.compress.archivers.sevenz;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;

public class SevenZArchiveEntry_equalSevenZMethods_3_0_Test {

    private boolean invokeEqualSevenZMethods(SevenZArchiveEntry entry, Iterable<SevenZMethodConfiguration> c1, Iterable<SevenZMethodConfiguration> c2) throws Exception {
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(entry, c1, c2);
    }

    @Test
    public void testEqualSevenZMethods_BothNull() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        assertTrue(invokeEqualSevenZMethods(entry, null, null), "Both method configurations are null, should be equal.");
    }

    @Test
    public void testEqualSevenZMethods_FirstNull() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Iterable<SevenZMethodConfiguration> second = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA));
        assertFalse(invokeEqualSevenZMethods(entry, null, second), "First method configuration is null, should not be equal.");
    }

    @Test
    public void testEqualSevenZMethods_SecondNull() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Iterable<SevenZMethodConfiguration> first = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA));
        assertFalse(invokeEqualSevenZMethods(entry, first, null), "Second method configuration is null, should not be equal.");
    }

    @Test
    public void testEqualSevenZMethods_DifferentSizes() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Iterable<SevenZMethodConfiguration> first = Arrays.asList(new SevenZMethodConfiguration(SevenZMethod.LZMA), new SevenZMethodConfiguration(SevenZMethod.LZMA));
        Iterable<SevenZMethodConfiguration> second = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA));
        assertFalse(invokeEqualSevenZMethods(entry, first, second), "Different sizes of method configurations, should not be equal.");
    }

    @Test
    public void testEqualSevenZMethods_DifferentMethods() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Iterable<SevenZMethodConfiguration> first = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA));
        Iterable<SevenZMethodConfiguration> second = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.DEFLATE));
        assertFalse(invokeEqualSevenZMethods(entry, first, second), "Different methods in configurations, should not be equal.");
    }

    @Test
    public void testEqualSevenZMethods_SameMethodsDifferentOptions() throws Exception {
        SevenZArchiveEntry entry = new SevenZArchiveEntry();
        Iterable<SevenZMethodConfiguration> first = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA, "option1"));
        Iterable<SevenZMethodConfiguration> second = Collections.singletonList(new SevenZMethodConfiguration(SevenZMethod.LZMA, "option2"));
        assertFalse(invokeEqualSevenZMethods(entry, first, second), "Same method but different options, should not be equal.");
    }
}
