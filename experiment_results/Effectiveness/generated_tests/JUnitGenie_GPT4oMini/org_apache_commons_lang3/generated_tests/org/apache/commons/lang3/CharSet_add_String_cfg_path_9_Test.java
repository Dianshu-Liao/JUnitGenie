package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAddWithValidRange() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add a range
            String input = "a-c";
            addMethod.invoke(charSet, input);

            // Verify that the range was added
            Set<CharRange> expectedSet = new HashSet<>();
            expectedSet.add(CharRange.isIn('a', 'c'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Removed Collections.synchronizedSet

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedRange() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add a negated range
            String input = "^a-c";
            addMethod.invoke(charSet, input);

            // Verify that the negated range was added
            Set<CharRange> expectedSet = new HashSet<>();
            expectedSet.add(CharRange.isNotIn('a', 'c'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Removed Collections.synchronizedSet

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedChar() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add a negated character
            String input = "^a";
            addMethod.invoke(charSet, input);

            // Verify that the negated character was added
            Set<CharRange> expectedSet = new HashSet<>();
            expectedSet.add(CharRange.isNot('a'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Removed Collections.synchronizedSet

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNullInput() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test null input
            String input = null;
            addMethod.invoke(charSet, input);

            // Verify that the set remains empty
            assertTrue(charSet.getCharRanges().length == 0); // Changed isEmpty() to check length

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}