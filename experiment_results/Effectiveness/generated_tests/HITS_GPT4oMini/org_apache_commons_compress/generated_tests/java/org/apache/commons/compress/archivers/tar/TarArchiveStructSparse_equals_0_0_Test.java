package org.apache.commons.compress.archivers.tar;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class TarArchiveStructSparse_equals_0_0_Test {

    @Test
    public void testEquals_SameObject() {
        TarArchiveStructSparse sparse = new TarArchiveStructSparse(10L, 20L);
        assertTrue(sparse.equals(sparse), "An object should be equal to itself.");
    }

    @Test
    public void testEquals_NullObject() {
        TarArchiveStructSparse sparse = new TarArchiveStructSparse(10L, 20L);
        assertFalse(sparse.equals(null), "An object should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        TarArchiveStructSparse sparse = new TarArchiveStructSparse(10L, 20L);
        String notSparse = "Not a TarArchiveStructSparse";
        assertFalse(sparse.equals(notSparse), "An object should not be equal to an instance of a different class.");
    }

    @Test
    public void testEquals_DifferentOffsets() {
        TarArchiveStructSparse sparse1 = new TarArchiveStructSparse(10L, 20L);
        TarArchiveStructSparse sparse2 = new TarArchiveStructSparse(15L, 20L);
        assertFalse(sparse1.equals(sparse2), "Objects with different offsets should not be equal.");
    }

    @Test
    public void testEquals_DifferentNumbytes() {
        TarArchiveStructSparse sparse1 = new TarArchiveStructSparse(10L, 20L);
        TarArchiveStructSparse sparse2 = new TarArchiveStructSparse(10L, 25L);
        assertFalse(sparse1.equals(sparse2), "Objects with different numbytes should not be equal.");
    }

    @Test
    public void testEquals_SameValues() {
        TarArchiveStructSparse sparse1 = new TarArchiveStructSparse(10L, 20L);
        TarArchiveStructSparse sparse2 = new TarArchiveStructSparse(10L, 20L);
        assertTrue(sparse1.equals(sparse2), "Objects with the same offset and numbytes should be equal.");
    }
}
