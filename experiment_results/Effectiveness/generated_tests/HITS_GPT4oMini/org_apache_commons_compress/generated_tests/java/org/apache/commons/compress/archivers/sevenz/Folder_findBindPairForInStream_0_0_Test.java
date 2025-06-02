package org.apache.commons.compress.archivers.sevenz;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

class Folder_findBindPairForInStream_0_0_Test {

    private Folder folder;

    @BeforeEach
    void setUp() {
        folder = new Folder();
    }

    @Test
    void testFindBindPairForInStream_WhenBindPairsIsNull_ShouldReturnMinusOne() {
        folder.bindPairs = null;
        int result = folder.findBindPairForInStream(0);
        assertEquals(-1, result);
    }

    @Test
    void testFindBindPairForInStream_WhenBindPairsIsEmpty_ShouldReturnMinusOne() {
        folder.bindPairs = new BindPair[0];
        int result = folder.findBindPairForInStream(0);
        assertEquals(-1, result);
    }

    @Test
    void testFindBindPairForInStream_WhenIndexExists_ShouldReturnCorrectIndex() {
        folder.bindPairs = new BindPair[] { new BindPair(0L, 0L), new BindPair(1L, 1L), new BindPair(2L, 2L) };
        int result = folder.findBindPairForInStream(1);
        assertEquals(1, result);
    }

    @Test
    void testFindBindPairForInStream_WhenIndexDoesNotExist_ShouldReturnMinusOne() {
        folder.bindPairs = new BindPair[] { new BindPair(0L, 0L), new BindPair(1L, 1L), new BindPair(2L, 2L) };
        int result = folder.findBindPairForInStream(3);
        assertEquals(-1, result);
    }

    @Test
    void testFindBindPairForInStream_WhenMultipleBindPairs_ShouldReturnFirstMatch() {
        folder.bindPairs = new BindPair[] { new BindPair(1L, 1L), new BindPair(1L, 1L), new BindPair(2L, 2L) };
        int result = folder.findBindPairForInStream(1);
        assertEquals(0, result);
    }
}
