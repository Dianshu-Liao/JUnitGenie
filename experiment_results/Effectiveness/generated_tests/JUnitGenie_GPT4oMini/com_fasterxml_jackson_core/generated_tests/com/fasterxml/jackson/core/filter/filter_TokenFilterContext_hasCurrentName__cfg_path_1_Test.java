package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class filter_TokenFilterContext_hasCurrentName__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasCurrentNameWhenCurrentNameIsNull() {
        try {
            // Create an instance of TokenFilterContext with _currentName set to null
            TokenFilterContext context = (TokenFilterContext) TokenFilterContext.class
                .getDeclaredConstructors()[0]
                .newInstance(0, null, null, false);
            
            // Access the protected field _currentName and set it to null
            java.lang.reflect.Field field = TokenFilterContext.class.getDeclaredField("_currentName");
            field.setAccessible(true);
            field.set(context, null);
            
            // Call the method under test
            boolean result = context.hasCurrentName();
            
            // Assert the expected outcome
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}