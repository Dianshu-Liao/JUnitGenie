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

public class CharSet_add_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAddValidCharacter() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected add method using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test with a valid character
            String input = "a";
            addMethod.invoke(charSet, input);

            // Verify that the character was added
            Set<CharRange> set = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.is('a')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddNegatedCharacter() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected add method using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test with a negated character
            String input = "^b";
            addMethod.invoke(charSet, input);

            // Verify that the negated character was added
            Set<CharRange> set = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNot('b')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddRange() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected add method using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test with a range
            String input = "a-c";
            addMethod.invoke(charSet, input);

            // Verify that the range was added
            Set<CharRange> set = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isIn('a', 'c')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddNegatedRange() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected add method using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test with a negated range
            String input = "^a-c";
            addMethod.invoke(charSet, input);

            // Verify that the negated range was added
            Set<CharRange> set = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNotIn('a', 'c')));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddNull() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected add method using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test with null input
            String input = null;
            addMethod.invoke(charSet, input);

            // Verify that the set is still empty
            Set<CharRange> set = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(set.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}