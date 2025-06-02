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

    private TokenFilterContext rootContext;

    private TokenFilterContext childContext;

    private TokenFilterContext grandChildContext;

    @BeforeEach
    public void setUp() {
        TokenFilter filter = TokenFilter.INCLUDE_ALL;
        rootContext = new TokenFilterContext(0, null, filter, true);
        childContext = new TokenFilterContext(1, rootContext, filter, true);
        grandChildContext = new TokenFilterContext(2, childContext, filter, true);
    }

    @Test
    public void testFindChildOf_ShouldReturnSelf_WhenParentIsRoot() {
        TokenFilterContext result = childContext.findChildOf(rootContext);
        assertEquals(childContext, result);
    }

    @Test
    public void testFindChildOf_ShouldReturnChild_WhenParentIsRootAndChildIsChild() {
        TokenFilterContext result = grandChildContext.findChildOf(rootContext);
        assertEquals(childContext, result);
    }

    @Test
    public void testFindChildOf_ShouldReturnNull_WhenParentIsNotFound() {
        TokenFilterContext nonExistentParent = new TokenFilterContext(3, null, TokenFilter.INCLUDE_ALL, true);
        TokenFilterContext result = grandChildContext.findChildOf(nonExistentParent);
        assertNull(result);
    }

    @Test
    public void testFindChildOf_ShouldReturnNull_WhenParentIsNull() {
        TokenFilterContext result = grandChildContext.findChildOf(null);
        assertNull(result);
    }

    @Test
    public void testFindChildOf_ShouldReturnSelf_WhenParentIsCurrentContext() {
        TokenFilterContext result = rootContext.findChildOf(rootContext);
        assertEquals(rootContext, result);
    }

    @Test
    public void testFindChildOf_ShouldReturnGrandChild_WhenParentIsChild() {
        TokenFilterContext result = grandChildContext.findChildOf(childContext);
        assertEquals(grandChildContext, result);
    }

    @Test
    public void testFindChildOf_ShouldReturnRoot_WhenSearchingFromChild() {
        TokenFilterContext result = childContext.findChildOf(rootContext);
        assertEquals(rootContext, result);
    }
}
