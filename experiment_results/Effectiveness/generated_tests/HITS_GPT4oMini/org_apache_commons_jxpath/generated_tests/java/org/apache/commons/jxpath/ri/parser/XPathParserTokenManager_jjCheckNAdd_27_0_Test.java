package org.apache.commons.jxpath.ri.parser;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class XPathParserTokenManager_jjCheckNAdd_27_0_Test {

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    void setUp() {
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader(""));
        tokenManager = new XPathParserTokenManager(stream);
    }

    @Test
    void testJjCheckNAdd_NewState() throws Exception {
        int state = 0;
        tokenManager.jjround = 1;
        invokeJjCheckNAdd(state);
        assertEquals(1, tokenManager.jjnewStateCnt);
    }

    @Test
    void testJjCheckNAdd_ExistingState() throws Exception {
        int state = 0;
        tokenManager.jjround = 1;
        setJjrounds(state, 1);
        invokeJjCheckNAdd(state);
        assertEquals(0, tokenManager.jjnewStateCnt);
    }

    @Test
    void testJjCheckNAdd_ChangeRound() throws Exception {
        int state = 1;
        tokenManager.jjround = 1;
        tokenManager.jjnewStateCnt = 0;
        invokeJjCheckNAdd(state);
        tokenManager.jjround = 2;
        invokeJjCheckNAdd(state);
        assertEquals(1, tokenManager.jjnewStateCnt);
    }

    private void setJjrounds(int index, int value) throws Exception {
        Field field = XPathParserTokenManager.class.getDeclaredField("jjrounds");
        field.setAccessible(true);
        int[] jjrounds = (int[]) field.get(tokenManager);
        jjrounds[index] = value;
    }

    private void invokeJjCheckNAdd(int state) {
        try {
            java.lang.reflect.Method method = XPathParserTokenManager.class.getDeclaredMethod("jjCheckNAdd", int.class);
            method.setAccessible(true);
            method.invoke(tokenManager, state);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
