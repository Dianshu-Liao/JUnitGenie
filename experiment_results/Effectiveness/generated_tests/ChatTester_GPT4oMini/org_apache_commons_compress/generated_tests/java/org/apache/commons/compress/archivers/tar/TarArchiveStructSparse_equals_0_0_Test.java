package org.apache.commons.compress.archivers.tar;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class TarArchiveStructSparse_equals_0_0_Test {

    private TarArchiveStructSparse sparse1;

    private TarArchiveStructSparse sparse2;

    private TarArchiveStructSparse sparse3;

    @BeforeEach
    public void setUp() {
        sparse1 = new TarArchiveStructSparse(100L, 200L);
        sparse2 = new TarArchiveStructSparse(100L, 200L);
        sparse3 = new TarArchiveStructSparse(150L, 250L);
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(sparse1.equals(sparse1), "An object should be equal to itself.");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(sparse1.equals(null), "An object should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(sparse1.equals("Not a TarArchiveStructSparse"), "An object should not be equal to an instance of a different class.");
    }

    @Test
    public void testEquals_SameValues() {
        assertTrue(sparse1.equals(sparse2), "Objects with the same offset and numbytes should be equal.");
    }

    @Test
    public void testEquals_DifferentValues() {
        assertFalse(sparse1.equals(sparse3), "Objects with different offset and numbytes should not be equal.");
    }

    @Test
    public void testEquals_DifferentOffsets() {
        TarArchiveStructSparse sparseWithDifferentOffset = new TarArchiveStructSparse(200L, 200L);
        assertFalse(sparse1.equals(sparseWithDifferentOffset), "Objects with different offsets should not be equal.");
    }

    @Test
    public void testEquals_DifferentNumbytes() {
        TarArchiveStructSparse sparseWithDifferentNumbytes = new TarArchiveStructSparse(100L, 300L);
        assertFalse(sparse1.equals(sparseWithDifferentNumbytes), "Objects with different numbytes should not be equal.");
    }
}
