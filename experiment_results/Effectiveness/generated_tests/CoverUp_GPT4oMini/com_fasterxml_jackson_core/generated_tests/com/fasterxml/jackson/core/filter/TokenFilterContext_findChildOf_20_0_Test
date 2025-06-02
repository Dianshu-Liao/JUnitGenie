package com.fasterxml.jackson.core.filter;

import java.lang.reflect.Method;
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

    private TokenFilterContext anotherChildContext;

    @BeforeEach
    public void setUp() {
        TokenFilter filter = TokenFilter.INCLUDE_ALL;
        rootContext = new TokenFilterContext(0, null, filter, true);
        childContext = new TokenFilterContext(1, rootContext, filter, false);
        anotherChildContext = new TokenFilterContext(2, childContext, filter, false);
    }

    @Test
    public void testFindChildOfReturnsSelfWhenParentIsCurrent() {
        TokenFilterContext result = rootContext.findChildOf(rootContext);
        assertEquals(rootContext, result);
    }

    @Test
    public void testFindChildOfReturnsChildWhenParentIsRoot() {
        TokenFilterContext result = childContext.findChildOf(rootContext);
        assertEquals(childContext, result);
    }

    @Test
    public void testFindChildOfReturnsNullWhenParentNotFound() {
        TokenFilterContext result = anotherChildContext.findChildOf(new TokenFilterContext(3, null, TokenFilter.INCLUDE_ALL, true));
        assertNull(result);
    }

    @Test
    public void testFindChildOfReturnsCorrectChildWhenParentIsGrandparent() {
        TokenFilterContext result = anotherChildContext.findChildOf(rootContext);
        assertEquals(childContext, result);
    }

    @Test
    public void testFindChildOfReturnsNullForNonExistentParent() {
        TokenFilterContext nonExistentParent = new TokenFilterContext(3, null, TokenFilter.INCLUDE_ALL, true);
        TokenFilterContext result = rootContext.findChildOf(nonExistentParent);
        assertNull(result);
    }

    // Reflection test to invoke private constructor
    @Test
    public void testPrivateConstructor() throws Exception {
        Class<?> clazz = TokenFilterContext.class;
        java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class);
        constructor.setAccessible(true);
        TokenFilterContext instance = (TokenFilterContext) constructor.newInstance(0, null, TokenFilter.INCLUDE_ALL, true);
        assertNotNull(instance);
    }
}
