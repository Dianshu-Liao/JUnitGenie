package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_21_Test {
    
    @Test(timeout = 4000)
    public void testAdd_withNegatedChar_shouldAddCharRange() {
        // Arrange
        CharSet charSet = new CharSet(new String[]{});
        String input = "^a"; // Example input for negated character

        // Access the protected add method using reflection
        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Act
            addMethod.invoke(charSet, input);
            
            // Assert
            // Check if the negation entry is added
            Set<CharRange> set = getPrivateSet(charSet);
            assertTrue(set.contains(CharRange.isNot('a')));

        } catch (Exception e) {
            e.printStackTrace();
            // Handle Exception
        }
    }

    // Helper method to access the private set variable
    private Set<CharRange> getPrivateSet(CharSet charSet) throws Exception {
        java.lang.reflect.Field field = CharSet.class.getDeclaredField("set");
        field.setAccessible(true);
        return (Set<CharRange>) field.get(charSet);
    }

}