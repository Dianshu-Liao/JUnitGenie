package org.apache.commons.compress.archivers.dump;

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

public class DumpArchiveEntry_setName_39_0_Test {

    private DumpArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new DumpArchiveEntry();
    }

    @Test
    public void testSetName_NullName() {
        entry.setName(null);
        assertEquals(null, entry.getName());
        assertEquals(null, entry.getOriginalName());
    }

    @Test
    public void testSetName_EmptyName() {
        entry.setName("");
        assertEquals("", entry.getName());
        assertEquals("", entry.getOriginalName());
    }

    @Test
    public void testSetName_ValidName() {
        String name = "testFile.txt";
        entry.setName(name);
        assertEquals(name, entry.getName());
        assertEquals(name, entry.getOriginalName());
    }

    @Test
    public void testSetName_NameWithLeadingDot() {
        String name = "./testFile.txt";
        entry.setName(name);
        assertEquals("testFile.txt", entry.getName());
        assertEquals(name, entry.getOriginalName());
    }

    @Test
    public void testSetName_DirectoryNameWithoutSlash() {
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY);
        String name = "testDir";
        entry.setName(name);
        assertEquals("testDir/", entry.getName());
        assertEquals(name, entry.getOriginalName());
    }

    @Test
    public void testSetName_DirectoryNameWithSlash() {
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY);
        String name = "testDir/";
        entry.setName(name);
        assertEquals(name, entry.getName());
        assertEquals(name, entry.getOriginalName());
    }

    @Test
    public void testSetName_NonDirectoryName() {
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        String name = "testFile.txt";
        entry.setName(name);
        assertEquals(name, entry.getName());
        assertEquals(name, entry.getOriginalName());
    }
}
