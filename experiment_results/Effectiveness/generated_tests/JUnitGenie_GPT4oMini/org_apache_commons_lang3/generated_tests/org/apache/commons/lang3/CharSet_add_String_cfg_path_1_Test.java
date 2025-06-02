package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddWithNegatedRange() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            addMethod.invoke(charSet, "^a-c");
            
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isNotIn('a', 'c'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to getCharRanges()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithRange() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            addMethod.invoke(charSet, "a-c");
            
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isIn('a', 'c'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to getCharRanges()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedChar() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            addMethod.invoke(charSet, "^a");
            
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.isNot('a'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to getCharRanges()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithSingleChar() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            addMethod.invoke(charSet, "a");
            
            Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
            expectedSet.add(CharRange.is('a'));
            assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to getCharRanges()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}