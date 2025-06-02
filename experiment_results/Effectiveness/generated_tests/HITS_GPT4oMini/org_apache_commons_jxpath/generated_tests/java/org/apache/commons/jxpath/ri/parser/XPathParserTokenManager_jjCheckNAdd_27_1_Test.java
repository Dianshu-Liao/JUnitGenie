package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XPathParserTokenManager_jjCheckNAdd_27_1_Test {

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        SimpleCharStream stream = new SimpleCharStream(new StringReader(""), 1, 1, 1);
        tokenManager = new XPathParserTokenManager(stream);
    }

    @Test
    public void testJjCheckNAdd_StateChanged() throws Exception {
        int state = 0;
        setField("jjround", 1);
        setField("jjrounds", state, 0);
        invokeMethod("jjCheckNAdd", state);
        assertEquals(1, getField("jjrounds", state), "The round for the state should be updated to the current round.");
        assertEquals(1, getField("jjnewStateCnt", 0), "The new state count should increment when the state is added.");
    }

    @Test
    public void testJjCheckNAdd_StateNotChanged() throws Exception {
        int state = 1;
        setField("jjround", 0);
        setField("jjrounds", state, 0);
        invokeMethod("jjCheckNAdd", state);
        assertEquals(0, getField("jjrounds", state), "The round for the state should not change.");
        assertEquals(0, getField("jjnewStateCnt", 0), "The new state count should not increment when the state is not added.");
    }

    @Test
    public void testJjCheckNAdd_MultipleStates() throws Exception {
        int state1 = 2;
        int state2 = 3;
        setField("jjround", 2);
        setField("jjrounds", state1, 0);
        setField("jjrounds", state2, 0);
        invokeMethod("jjCheckNAdd", state1);
        invokeMethod("jjCheckNAdd", state2);
        assertEquals(2, getField("jjrounds", state1), "The round for state1 should be updated to the current round.");
        assertEquals(2, getField("jjrounds", state2), "The round for state2 should be updated to the current round.");
        assertEquals(2, getField("jjnewStateCnt", 0), "The new state count should reflect the added states.");
    }

    private void setField(String fieldName, int value) throws Exception {
        Field field = XPathParserTokenManager.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(tokenManager, value);
    }

    private void setField(String fieldName, int index, int value) throws Exception {
        Field field = XPathParserTokenManager.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        int[] array = (int[]) field.get(tokenManager);
        array[index] = value;
    }

    private int getField(String fieldName, int index) throws Exception {
        Field field = XPathParserTokenManager.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        int[] array = (int[]) field.get(tokenManager);
        return array[index];
    }

    private void invokeMethod(String methodName, int arg) throws Exception {
        Method method = XPathParserTokenManager.class.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(tokenManager, arg);
    }
}
