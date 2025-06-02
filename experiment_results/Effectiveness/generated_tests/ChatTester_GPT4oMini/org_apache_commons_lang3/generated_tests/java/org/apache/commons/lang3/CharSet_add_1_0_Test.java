package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class CharSet_add_1_0_Test {

    private CharSet charSet;

    @BeforeEach
    public void setUp() {
        charSet = new CharSet();
    }

    @Test
    public void testAdd_NullString() throws Exception {
        invokeAddMethod(null);
        assertTrue(getCharSetSet().isEmpty());
    }

    @Test
    public void testAdd_SingleCharacter() throws Exception {
        invokeAddMethod("a");
        assertEquals(1, getCharSetSet().size());
    }

    @Test
    public void testAdd_NegatedCharacter() throws Exception {
        invokeAddMethod("^a");
        assertEquals(1, getCharSetSet().size());
    }

    @Test
    public void testAdd_Range() throws Exception {
        invokeAddMethod("a-c");
        assertEquals(3, getCharSetSet().size());
    }

    @Test
    public void testAdd_NegatedRange() throws Exception {
        invokeAddMethod("^a-c");
        assertEquals(3, getCharSetSet().size());
    }

    @Test
    public void testAdd_ComplexInput() throws Exception {
        invokeAddMethod("a-c^b");
        assertEquals(5, getCharSetSet().size());
    }

    private void invokeAddMethod(String str) throws Exception {
        Method method = CharSet.class.getDeclaredMethod("add", String.class);
        method.setAccessible(true);
        method.invoke(charSet, str);
    }

    @SuppressWarnings("unchecked")
    private Set<CharRange> getCharSetSet() throws Exception {
        java.lang.reflect.Field field = CharSet.class.getDeclaredField("set");
        field.setAccessible(true);
        return (Set<CharRange>) field.get(charSet);
    }
}
