package org.apache.commons.compress.harmony.pack200;

import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.objectweb.asm.Attribute;

public class PackingOptions_isPassFile_21_0_Test {

    private PackingOptions packingOptions;

    @BeforeEach
    public void setUp() {
        packingOptions = new PackingOptions();
    }

    @Test
    public void testIsPassFile_WhenPassFileNameMatchesExactPassFile() {
        packingOptions.addPassFile("example.class");
        assertTrue(packingOptions.isPassFile("example.class"));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameStartsWithPassDirectory() {
        packingOptions.addPassFile("exampleDir/");
        assertTrue(packingOptions.isPassFile("exampleDir/someFile.txt"));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameDoesNotMatch() {
        packingOptions.addPassFile("exampleDir/");
        assertFalse(packingOptions.isPassFile("someOtherDir/someFile.txt"));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameIsSubdirectoryOfPassDirectory() {
        packingOptions.addPassFile("exampleDir/");
        assertFalse(packingOptions.isPassFile("exampleDirSub/someFile.txt"));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameIsEmpty() {
        packingOptions.addPassFile("exampleDir/");
        assertFalse(packingOptions.isPassFile(""));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameIsNull() {
        packingOptions.addPassFile("exampleDir/");
        assertFalse(packingOptions.isPassFile(null));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameMatchesClassFile() {
        packingOptions.addPassFile("example.class");
        assertTrue(packingOptions.isPassFile("example.class"));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameMatchesNonClassFileWithDirectory() {
        packingOptions.addPassFile("exampleDir/");
        assertTrue(packingOptions.isPassFile("exampleDir/someFile.txt"));
    }

    @Test
    public void testIsPassFile_WhenPassFileNameMatchesMultipleEntries() {
        packingOptions.addPassFile("dir1/");
        packingOptions.addPassFile("dir2/");
        packingOptions.addPassFile("file.class");
        assertTrue(packingOptions.isPassFile("dir1/someFile.txt"));
        assertTrue(packingOptions.isPassFile("file.class"));
        assertFalse(packingOptions.isPassFile("dir3/someFile.txt"));
    }
}
