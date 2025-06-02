package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class filter_TokenFilterContext_hasCurrentName__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasCurrentNameWhenCurrentNameIsNull() {
        try {
            // Using reflection to access the protected constructor
            TokenFilterContext context = (TokenFilterContext) TokenFilterContext.class
                .getDeclaredConstructors()[0]
                .newInstance(0, null, null, false);
            
            // Setting _currentName to null using reflection
            java.lang.reflect.Field field = TokenFilterContext.class.getDeclaredField("_currentName");
            field.setAccessible(true);
            field.set(context, null);
            
            // Assert that hasCurrentName returns false
            assertFalse(context.hasCurrentName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}