package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;

public class CharSet_add_String_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testAddMethodWithNegatedChar() {
        try {
            // Create an instance of CharSet
            CharSet charSet = new CharSet();

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Prepare test input
            String testInput = "^a"; // Represents a negated character 'a'

            // Invoke the 'add' method
            addMethod.invoke(charSet, testInput);

            // Verify the internal state of the set
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isNot('a'));
            assertEquals(expectedSet, getPrivateSet(charSet));
        } catch (Exception e) {
            // Handle exception
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddMethodWithValidRange() {
        try {
            // Create an instance of CharSet
            CharSet charSet = new CharSet();

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Prepare test input
            String testInput = "a-b"; // Represents character range from 'a' to 'b'

            // Invoke the 'add' method
            addMethod.invoke(charSet, testInput);

            // Verify the internal state of the set
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isIn('a', 'b'));
            assertEquals(expectedSet, getPrivateSet(charSet));
        } catch (Exception e) {
            // Handle exception
            fail("Exception occurred: " + e.getMessage());
        }
    }

    private Set<CharRange> getPrivateSet(CharSet charSet) throws Exception {
        // Access the private field 'set' using reflection
        java.lang.reflect.Field setField = CharSet.class.getDeclaredField("set");
        setField.setAccessible(true);
        return (Set<CharRange>) setField.get(charSet);
    }

}