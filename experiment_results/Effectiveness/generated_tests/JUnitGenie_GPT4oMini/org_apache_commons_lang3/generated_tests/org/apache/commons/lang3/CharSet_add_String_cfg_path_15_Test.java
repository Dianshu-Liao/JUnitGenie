package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testAddWithValidCharacter() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should be processed
            String input = "a"; // valid character
            addMethod.invoke(charSet, input);

            // Verify that the character was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.is('a')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedCharacter() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should be processed
            String input = "^b"; // negated character
            addMethod.invoke(charSet, input);

            // Verify that the negated character was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNot('b')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithRange() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should be processed
            String input = "a-c"; // range
            addMethod.invoke(charSet, input);

            // Verify that the range was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isIn('a', 'c')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedRange() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should be processed
            String input = "^a-c"; // negated range
            addMethod.invoke(charSet, input);

            // Verify that the negated range was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNotIn('a', 'c')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}