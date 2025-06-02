package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class TarArchiveStructSparse_equals_0_0_Test {

    @Test
    public void testEquals_SameReference() {
        TarArchiveStructSparse instance = new TarArchiveStructSparse(10L, 20L);
        assertTrue(instance.equals(instance), "Instances should be equal when they are the same reference.");
    }

    @Test
    public void testEquals_NullObject() {
        TarArchiveStructSparse instance = new TarArchiveStructSparse(10L, 20L);
        assertFalse(instance.equals(null), "Instance should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        TarArchiveStructSparse instance = new TarArchiveStructSparse(10L, 20L);
        Object other = new Object();
        assertFalse(instance.equals(other), "Instance should not be equal to an object of a different class.");
    }

    @Test
    public void testEquals_DifferentValues() {
        TarArchiveStructSparse instance1 = new TarArchiveStructSparse(10L, 20L);
        TarArchiveStructSparse instance2 = new TarArchiveStructSparse(10L, 30L);
        assertFalse(instance1.equals(instance2), "Instances with different numbytes should not be equal.");
        TarArchiveStructSparse instance3 = new TarArchiveStructSparse(15L, 20L);
        assertFalse(instance1.equals(instance3), "Instances with different offsets should not be equal.");
    }

    @Test
    public void testEquals_SameValues() {
        TarArchiveStructSparse instance1 = new TarArchiveStructSparse(10L, 20L);
        TarArchiveStructSparse instance2 = new TarArchiveStructSparse(10L, 20L);
        assertTrue(instance1.equals(instance2), "Instances with the same offset and numbytes should be equal.");
    }
}
