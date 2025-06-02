package com.fasterxml.jackson.core.filter;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.core.*;

public class TokenFilterContext_findChildOf_20_0_Test {

    private TokenFilterContext root;

    private TokenFilterContext child1;

    private TokenFilterContext child2;

    private TokenFilterContext child3;

    @BeforeEach
    public void setUp() {
        // Assuming TokenFilter is a class that can be instantiated
        // Replace with actual constructor if needed
        TokenFilter filter = new TokenFilter();
        root = new TokenFilterContext(0, null, filter, false);
        child1 = new TokenFilterContext(1, root, filter, false);
        child2 = new TokenFilterContext(2, child1, filter, false);
        child3 = new TokenFilterContext(3, child1, filter, false);
    }

    @Test
    public void testFindChildOf_WithDirectParent() {
        TokenFilterContext result = root.findChildOf(root);
        assertEquals(root, result);
    }

    @Test
    public void testFindChildOf_WithIndirectParent() {
        TokenFilterContext result = child2.findChildOf(root);
        assertEquals(root, result);
    }

    @Test
    public void testFindChildOf_WithNoParent() {
        TokenFilterContext result = child2.findChildOf(child3);
        assertNull(result);
    }

    @Test
    public void testFindChildOf_WithSameParent() {
        TokenFilterContext result = child1.findChildOf(child1);
        assertEquals(child1, result);
    }

    @Test
    public void testFindChildOf_WithNullParent() {
        TokenFilterContext result = child2.findChildOf(null);
        assertNull(result);
    }

    @Test
    public void testFindChildOf_WithNonExistentParent() {
        TokenFilterContext nonExistentParent = new TokenFilterContext(4, null, new TokenFilter(), false);
        TokenFilterContext result = child2.findChildOf(nonExistentParent);
        assertNull(result);
    }
}
