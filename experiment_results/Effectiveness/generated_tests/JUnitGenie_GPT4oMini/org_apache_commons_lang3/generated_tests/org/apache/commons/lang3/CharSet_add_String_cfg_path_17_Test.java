package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testAddMethodWithValidCharRange() {
        CharSet charSet = new CharSet(new String[]{});
        
        // Access the protected method 'add' using reflection
        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test valid range: a-z (should add CharRange.isIn('a', 'z'))
            String input = "a-z";
            addMethod.invoke(charSet, input);
            
            // Check the internal state of the set
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isIn('a', 'z'));
            assertTrue(getSet(charSet).containsAll(expectedSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to retrieve the private final set for testing purposes
    private Set<CharRange> getSet(CharSet charSet) {
        try {
            Field field = CharSet.class.getDeclaredField("set");
            field.setAccessible(true);
            return (Set<CharRange>) field.get(charSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}