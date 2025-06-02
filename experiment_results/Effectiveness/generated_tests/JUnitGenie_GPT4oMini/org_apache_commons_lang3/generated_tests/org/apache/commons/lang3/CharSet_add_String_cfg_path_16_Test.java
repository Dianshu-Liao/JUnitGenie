package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testAddMethod() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that will go through the CFG path
            String testInput = "a-b^c";
            addMethod.invoke(charSet, testInput);

            // Verify that the expected CharRange objects are added to the set
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.is('a')); // Corrected to match the method signature
            expectedSet.add(CharRange.is('b')); // Corrected to match the method signature
            expectedSet.add(CharRange.isNot('c'));

            // Access the private field 'set' using reflection
            java.lang.reflect.Field setField = CharSet.class.getDeclaredField("set");
            setField.setAccessible(true);
            Set<CharRange> actualSet = (Set<CharRange>) setField.get(charSet);

            // Check if the actual set contains the expected CharRange objects
            assertTrue(actualSet.containsAll(expectedSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}