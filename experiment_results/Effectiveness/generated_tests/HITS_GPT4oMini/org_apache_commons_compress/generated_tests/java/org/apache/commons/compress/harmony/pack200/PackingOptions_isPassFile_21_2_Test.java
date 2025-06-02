package org.apache.commons.compress.harmony.pack200;

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

public class PackingOptions_isPassFile_21_2_Test {

    private PackingOptions packingOptions;

    @BeforeEach
    public void setUp() {
        packingOptions = new PackingOptions();
    }

    @Test
    public void testIsPassFile_WithExactMatch() {
        packingOptions.addPassFile("example.class");
        assertTrue(packingOptions.isPassFile("example.class"));
    }

    @Test
    public void testIsPassFile_WithDirectoryMatch() {
        packingOptions.addPassFile("exampleDir/");
        assertTrue(packingOptions.isPassFile("exampleDir/somefile.txt"));
    }

    @Test
    public void testIsPassFile_WithNoMatch() {
        packingOptions.addPassFile("example.class");
        assertFalse(packingOptions.isPassFile("notmatching.class"));
    }

    @Test
    public void testIsPassFile_WithNestedDirectory() {
        packingOptions.addPassFile("exampleDir/");
        assertTrue(packingOptions.isPassFile("exampleDir/subdir/somefile.txt"));
    }

    @Test
    public void testIsPassFile_WithMultipleFiles() {
        packingOptions.addPassFile("example1.class");
        packingOptions.addPassFile("example2.class");
        assertTrue(packingOptions.isPassFile("example1.class"));
        assertTrue(packingOptions.isPassFile("example2.class"));
        assertFalse(packingOptions.isPassFile("example3.class"));
    }

    @Test
    public void testIsPassFile_WithEmptyPassFiles() {
        assertFalse(packingOptions.isPassFile("anything.class"));
    }

    @Test
    public void testIsPassFile_WithPartialMatch() {
        packingOptions.addPassFile("exampleDir/");
        assertTrue(packingOptions.isPassFile("exampleDir/"));
        assertTrue(packingOptions.isPassFile("exampleDir/somefile.class"));
        assertFalse(packingOptions.isPassFile("exampleDir2/somefile.class"));
    }

    @Test
    public void testIsPassFile_WithTrailingSlash() {
        packingOptions.addPassFile("exampleDir");
        assertTrue(packingOptions.isPassFile("exampleDir/somefile.txt"));
    }

    @Test
    public void testIsPassFile_WithMixedEntries() {
        packingOptions.addPassFile("exampleDir/");
        packingOptions.addPassFile("example.class");
        assertTrue(packingOptions.isPassFile("example.class"));
        assertTrue(packingOptions.isPassFile("exampleDir/somefile.txt"));
        assertFalse(packingOptions.isPassFile("anotherDir/somefile.txt"));
    }
}
