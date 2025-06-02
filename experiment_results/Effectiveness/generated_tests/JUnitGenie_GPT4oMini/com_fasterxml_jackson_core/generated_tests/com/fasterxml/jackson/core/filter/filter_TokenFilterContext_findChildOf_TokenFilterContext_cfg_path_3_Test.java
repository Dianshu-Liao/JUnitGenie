package com.fasterxml.jackson.core.filter;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.lang.reflect.Constructor;

public class filter_TokenFilterContext_findChildOf_TokenFilterContext_cfg_path_3_Test {
    private TokenFilterContext childContext;
    private TokenFilterContext parentContext;

    @Before
    public void setUp() throws Exception {
        // Use reflection to access the protected constructor
        Constructor<TokenFilterContext> constructor = TokenFilterContext.class.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class);
        constructor.setAccessible(true);
        
        // Creating a parent context
        parentContext = constructor.newInstance(0, null, null, false);
        
        // Creating a child context that refers to the parent context
        childContext = constructor.newInstance(1, parentContext, null, false);
    }

    @Test(timeout = 4000)
    public void testFindChildOfWithParent() {
        // Test case where childContext has the parentContext as _parent
        TokenFilterContext result = childContext.findChildOf(parentContext);
        assertEquals(parentContext, result);
    }

    @Test(timeout = 4000)
    public void testFindChildOfWithSelf() {
        // Test case where the input is the child context itself
        TokenFilterContext result = childContext.findChildOf(childContext);
        assertEquals(childContext, result);
    }

    @Test(timeout = 4000)
    public void testFindChildOfWithNull() {
        // Test case where parent is null
        TokenFilterContext result = childContext.findChildOf(null);
        assertEquals(null, result);
    }

}