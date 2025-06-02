package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAddWithValidRange() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that represents a valid range
            String input = "a-c";
            addMethod.invoke(charSet, input);

            // Verify that the set contains the expected CharRange
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isIn('a', 'c'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedRange() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that represents a negated range
            String input = "^a-c";
            addMethod.invoke(charSet, input);

            // Verify that the set contains the expected CharRange
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isNotIn('a', 'c'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithSingleCharacter() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that represents a single character
            String input = "a";
            addMethod.invoke(charSet, input);

            // Verify that the set contains the expected CharRange
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.is('a'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedCharacter() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that represents a negated character
            String input = "^a";
            addMethod.invoke(charSet, input);

            // Verify that the set contains the expected CharRange
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isNot('a'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}