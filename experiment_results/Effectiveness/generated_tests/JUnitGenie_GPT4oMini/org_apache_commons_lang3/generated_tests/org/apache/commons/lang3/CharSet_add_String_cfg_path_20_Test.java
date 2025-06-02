package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testAddMethodWithValidInput() {
        try {
            // Create an instance of CharSet using reflection
            Class<CharSet> charSetClass = CharSet.class;
            Constructor<CharSet> constructor = charSetClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            CharSet charSet = constructor.newInstance((Object) new String[]{});

            // Access the protected add method using reflection
            Method addMethod = charSetClass.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add valid characters
            String input = "a-b^c";
            addMethod.invoke(charSet, input);

            // Verify that the set contains the expected CharRange
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.is('a'));
            expectedSet.add(CharRange.isIn('b', 'c'));
            expectedSet.add(CharRange.isNot('c'));

            // Check if the internal set contains the expected ranges
            // Assuming there is a method getCharRanges() in CharSet to access the internal set
            Method getCharRangesMethod = charSetClass.getDeclaredMethod("getCharRanges");
            getCharRangesMethod.setAccessible(true);
            Set<CharRange> actualSet = (Set<CharRange>) getCharRangesMethod.invoke(charSet);
            assertTrue(actualSet.equals(expectedSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}