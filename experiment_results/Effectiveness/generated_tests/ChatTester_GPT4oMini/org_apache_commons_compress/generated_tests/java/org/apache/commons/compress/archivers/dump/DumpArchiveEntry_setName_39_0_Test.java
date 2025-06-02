package org.apache.commons.compress.archivers.dump;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;

class DumpArchiveEntry_setName_39_0_Test {

    private DumpArchiveEntry entry;

    @BeforeEach
    void setUp() {
        entry = new DumpArchiveEntry();
    }

    @Test
    void testSetName_NullName() throws Exception {
        entry.setName(null);
        assertNull(getPrivateField("name", entry));
        assertNull(getPrivateField("originalName", entry));
    }

    @Test
    void testSetName_ValidName() throws Exception {
        entry.setName("testFile");
        assertEquals("testFile", getPrivateField("name", entry));
        assertEquals("testFile", getPrivateField("originalName", entry));
    }

    @Test
    void testSetName_DirectoryNameWithoutSlash() throws Exception {
        setIsDirectory(true);
        entry.setName("testDir");
        assertEquals("testDir/", getPrivateField("name", entry));
        assertEquals("testDir", getPrivateField("originalName", entry));
    }

    @Test
    void testSetName_DirectoryNameWithSlash() throws Exception {
        setIsDirectory(true);
        entry.setName("testDir/");
        assertEquals("testDir/", getPrivateField("name", entry));
        assertEquals("testDir/", getPrivateField("originalName", entry));
    }

    @Test
    void testSetName_NameWithDot() throws Exception {
        entry.setName("./testFile");
        assertEquals("testFile", getPrivateField("name", entry));
        assertEquals("./testFile", getPrivateField("originalName", entry));
    }

    @Test
    void testSetName_EmptyName() throws Exception {
        entry.setName("");
        assertEquals("", getPrivateField("name", entry));
        assertEquals("", getPrivateField("originalName", entry));
    }

    private Object getPrivateField(String fieldName, DumpArchiveEntry entry) throws Exception {
        java.lang.reflect.Field field = DumpArchiveEntry.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(entry);
    }

    private void setIsDirectory(boolean isDirectory) throws Exception {
        Method method = DumpArchiveEntry.class.getDeclaredMethod("setIsDirectory", boolean.class);
        method.setAccessible(true);
        method.invoke(entry, isDirectory);
    }
}
