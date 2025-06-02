package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class filter_TokenFilterContext_findChildOf_TokenFilterContext_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFindChildOf() {
        try {
            // Create parent and child TokenFilterContext instances
            TokenFilterContext parent = new TokenFilterContext(0, null, null, false);
            TokenFilterContext child = new TokenFilterContext(1, parent, null, false);
            // Set the _parent field using reflection
            java.lang.reflect.Field parentField = TokenFilterContext.class.getDeclaredField("_parent");
            parentField.setAccessible(true);
            parentField.set(child, parent);

            // Call the method under test
            TokenFilterContext result = child.findChildOf(parent);

            // Assert that the result is the child itself
            assertEquals(child, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}