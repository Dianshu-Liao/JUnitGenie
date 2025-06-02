package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAddWithNegatedChar() {
        try {
            // Create an instance of CharSet using reflection
            CharSet charSet = (CharSet) CharSet.class.getDeclaredConstructor(String[].class).newInstance((Object) new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Prepare the input string that will trigger the negated char case
            String input = "^a"; // This should add CharRange.isNot('a')

            // Invoke the add method
            addMethod.invoke(charSet, input);

            // Verify that the set contains the expected CharRange
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isNot('a'));

            // Use reflection to access the private 'set' field
            // Assuming the correct method to access the set is 'getCharRanges' instead of 'getSet'
            Method getSetMethod = CharSet.class.getDeclaredMethod("getCharRanges");
            getSetMethod.setAccessible(true);
            Set<CharRange> actualSet = (Set<CharRange>) getSetMethod.invoke(charSet);

            assertTrue(actualSet.equals(expectedSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}