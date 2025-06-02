package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class text_StrTokenizer_checkTokenized__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCheckTokenized_whenTokensAreNull() {
        // Arrange
        StrTokenizer strTokenizer = new StrTokenizer();
        
        // Act
        invokeCheckTokenized(strTokenizer);
        
        // Assert
        String[] tokensField = getTokensField(strTokenizer);
        assertNotNull(tokensField);
    }

    private void invokeCheckTokenized(StrTokenizer strTokenizer) {
        try {
            Method method = StrTokenizer.class.getDeclaredMethod("checkTokenized");
            method.setAccessible(true);
            method.invoke(strTokenizer);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }

    private String[] getTokensField(StrTokenizer strTokenizer) {
        try {
            java.lang.reflect.Field field = StrTokenizer.class.getDeclaredField("tokens");
            field.setAccessible(true);
            return (String[]) field.get(strTokenizer);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as needed
            return null;
        }
    }

}