package org.apache.commons.compress.archivers.dump;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import java.util.Date;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.EnumSet;
import java.util.HashSet;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class DumpArchiveEntry_setName_39_0_Test {

    private DumpArchiveEntry entry;

    private enum TYPE {

        UNKNOWN, DIRECTORY
    }

    private enum PERMISSION {
        ;

        // Add necessary permission constants here
        static Set<PERMISSION> find(int mode) {
            return Collections.emptySet();
        }
    }

    @BeforeEach
    public void setUp() {
        entry = new DumpArchiveEntry();
    }

    @Test
    public void testSetName_NullName() throws Exception {
        entry.setName(null);
        assertEquals(null, entry.getName());
        assertEquals(null, invokeGetOriginalName(entry));
    }

    @Test
    public void testSetName_EmptyName() throws Exception {
        entry.setName("");
        assertEquals("", entry.getName());
        assertEquals("", invokeGetOriginalName(entry));
    }

    @Test
    public void testSetName_ValidName() throws Exception {
        entry.setName("testFile");
        assertEquals("testFile", entry.getName());
        assertEquals("testFile", invokeGetOriginalName(entry));
    }

    @Test
    public void testSetName_ValidDirectoryName() throws Exception {
        setEntryType(entry, TYPE.DIRECTORY);
        entry.setName("testDir");
        assertEquals("testDir/", entry.getName());
        assertEquals("testDir", invokeGetOriginalName(entry));
    }

    @Test
    public void testSetName_DirectoryNameWithoutSlash() throws Exception {
        setEntryType(entry, TYPE.DIRECTORY);
        entry.setName("testDir/");
        assertEquals("testDir/", entry.getName());
        assertEquals("testDir/", invokeGetOriginalName(entry));
    }

    @Test
    public void testSetName_NameWithDot() throws Exception {
        entry.setName("./testFile");
        assertEquals("testFile", entry.getName());
        assertEquals("./testFile", invokeGetOriginalName(entry));
    }

    private void setEntryType(DumpArchiveEntry entry, TYPE type) throws Exception {
        Method method = DumpArchiveEntry.class.getDeclaredMethod("setType", TYPE.class);
        method.setAccessible(true);
        method.invoke(entry, type);
    }

    private String invokeGetOriginalName(DumpArchiveEntry entry) throws Exception {
        Method method = DumpArchiveEntry.class.getDeclaredMethod("getOriginalName");
        method.setAccessible(true);
        return (String) method.invoke(entry);
    }

    private boolean isDirectory() throws Exception {
        Method method = DumpArchiveEntry.class.getDeclaredMethod("isDirectory");
        method.setAccessible(true);
        return (boolean) method.invoke(entry);
    }
}
