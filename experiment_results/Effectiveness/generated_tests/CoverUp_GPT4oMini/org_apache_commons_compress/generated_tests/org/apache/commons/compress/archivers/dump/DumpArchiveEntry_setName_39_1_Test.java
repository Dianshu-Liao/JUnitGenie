package org.apache.commons.compress.archivers.dump;

import java.lang.reflect.Method;
import java.util.Collections;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class DumpArchiveEntry_setName_39_1_Test {

    private DumpArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new DumpArchiveEntry();
    }

    @Test
    public void testSetName_Null() throws Exception {
        invokeSetName(entry, null);
        assertEquals(null, entry.getName());
        assertEquals(null, entry.getOriginalName());
    }

    @Test
    public void testSetName_Empty() throws Exception {
        invokeSetName(entry, "");
        assertEquals("", entry.getName());
        assertEquals("", entry.getOriginalName());
    }

    @Test
    public void testSetName_ValidName() throws Exception {
        invokeSetName(entry, "testName");
        assertEquals("testName", entry.getName());
        assertEquals("testName", entry.getOriginalName());
    }

    @Test
    public void testSetName_WithDirectory() throws Exception {
        invokeSetType(entry, "DIRECTORY");
        invokeSetName(entry, "testDir");
        assertEquals("testDir/", entry.getName());
        assertEquals("testDir", entry.getOriginalName());
    }

    @Test
    public void testSetName_WithDirectory_NoTrailingSlash() throws Exception {
        invokeSetType(entry, "DIRECTORY");
        invokeSetName(entry, "testDir/");
        assertEquals("testDir/", entry.getName());
        assertEquals("testDir/", entry.getOriginalName());
    }

    @Test
    public void testSetName_WithRelativePath() throws Exception {
        invokeSetName(entry, "./testFile");
        assertEquals("testFile", entry.getName());
        assertEquals("./testFile", entry.getOriginalName());
    }

    private void invokeSetName(DumpArchiveEntry entry, String name) throws Exception {
        Method method = DumpArchiveEntry.class.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        method.invoke(entry, name);
    }

    private void invokeSetType(DumpArchiveEntry entry, String typeName) throws Exception {
        Method method = DumpArchiveEntry.class.getDeclaredMethod("setType", TYPE.class);
        method.setAccessible(true);
        TYPE type = TYPE.valueOf(typeName);
        method.invoke(entry, type);
    }

    // Assuming TYPE is an enum defined in the same package
    public enum TYPE {

        UNKNOWN, DIRECTORY, FILE
    }
}
