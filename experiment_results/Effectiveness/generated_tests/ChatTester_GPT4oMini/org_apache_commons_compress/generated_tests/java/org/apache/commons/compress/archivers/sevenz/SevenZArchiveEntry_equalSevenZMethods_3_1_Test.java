// Test method
package org.apache.commons.compress.archivers.sevenz;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.nio.file.attribute.FileTime;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;

class SevenZArchiveEntry_equalSevenZMethods_3_1_Test {

    private SevenZArchiveEntry entry;

    @BeforeEach
    void setUp() {
        entry = new SevenZArchiveEntry();
    }

    @Test
    void testEqualSevenZMethods_NullBoth() throws Exception {
        assertTrue(invokeEqualSevenZMethods(null, null));
    }

    @Test
    void testEqualSevenZMethods_NullFirst() throws Exception {
        assertFalse(invokeEqualSevenZMethods(null, Collections.singletonList(new MockSevenZMethodConfiguration("method1"))));
    }

    @Test
    void testEqualSevenZMethods_NullSecond() throws Exception {
        assertFalse(invokeEqualSevenZMethods(Collections.singletonList(new MockSevenZMethodConfiguration("method1")), null));
    }

    @Test
    void testEqualSevenZMethods_DifferentSizes() throws Exception {
        List<MockSevenZMethodConfiguration> c1 = Arrays.asList(new MockSevenZMethodConfiguration("method1"));
        List<MockSevenZMethodConfiguration> c2 = Arrays.asList(new MockSevenZMethodConfiguration("method1"), new MockSevenZMethodConfiguration("method2"));
        assertFalse(invokeEqualSevenZMethods(c1, c2));
    }

    @Test
    void testEqualSevenZMethods_DifferentElements() throws Exception {
        List<MockSevenZMethodConfiguration> c1 = Arrays.asList(new MockSevenZMethodConfiguration("method1"));
        List<MockSevenZMethodConfiguration> c2 = Arrays.asList(new MockSevenZMethodConfiguration("method2"));
        assertFalse(invokeEqualSevenZMethods(c1, c2));
    }

    @Test
    void testEqualSevenZMethods_SameElements() throws Exception {
        List<MockSevenZMethodConfiguration> c1 = Arrays.asList(new MockSevenZMethodConfiguration("method1"));
        List<MockSevenZMethodConfiguration> c2 = Arrays.asList(new MockSevenZMethodConfiguration("method1"));
        assertTrue(invokeEqualSevenZMethods(c1, c2));
    }

    @Test
    void testEqualSevenZMethods_ExtraElementsInSecond() throws Exception {
        List<MockSevenZMethodConfiguration> c1 = Arrays.asList(new MockSevenZMethodConfiguration("method1"));
        List<MockSevenZMethodConfiguration> c2 = Arrays.asList(new MockSevenZMethodConfiguration("method1"), new MockSevenZMethodConfiguration("method2"));
        assertFalse(invokeEqualSevenZMethods(c1, c2));
    }

    private boolean invokeEqualSevenZMethods(Iterable<? extends SevenZMethodConfiguration> c1, Iterable<? extends SevenZMethodConfiguration> c2) throws Exception {
        Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(entry, c1, c2);
    }

    private static class MockSevenZMethodConfiguration extends SevenZMethodConfiguration {

        private final String name;

        MockSevenZMethodConfiguration(String name) {
            // Assuming null is a valid argument for the constructor
            super(null);
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof MockSevenZMethodConfiguration))
                return false;
            MockSevenZMethodConfiguration other = (MockSevenZMethodConfiguration) obj;
            return name.equals(other.name);
        }
    }
}
