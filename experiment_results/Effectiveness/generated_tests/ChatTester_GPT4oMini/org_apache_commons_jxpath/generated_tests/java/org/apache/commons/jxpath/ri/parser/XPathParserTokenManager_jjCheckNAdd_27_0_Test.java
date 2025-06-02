package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class XPathParserTokenManager_jjCheckNAdd_27_0_Test {

    private XPathParserTokenManager parserTokenManager;

    @BeforeEach
    public void setUp() {
        // Create a SimpleCharStream with a StringReader for testing
        parserTokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
    }

    @Test
    public void testJjCheckNAdd_NewState() throws Exception {
        // Set up the necessary fields using reflection
        Field jjnewStateCntField = XPathParserTokenManager.class.getDeclaredField("jjnewStateCnt");
        Field jjroundsField = XPathParserTokenManager.class.getDeclaredField("jjrounds");
        Field jjroundField = XPathParserTokenManager.class.getDeclaredField("jjround");
        Field jjstateSetField = XPathParserTokenManager.class.getDeclaredField("jjstateSet");
        jjnewStateCntField.setAccessible(true);
        jjroundsField.setAccessible(true);
        jjroundField.setAccessible(true);
        jjstateSetField.setAccessible(true);
        int state = 0;
        // Set round to 1
        jjroundField.setInt(parserTokenManager, 1);
        int[] jjrounds = (int[]) jjroundsField.get(parserTokenManager);
        // Set previous round to 0
        jjrounds[state] = 0;
        int[] jjstateSet = (int[]) jjstateSetField.get(parserTokenManager);
        // Reset new state count
        jjnewStateCntField.setInt(parserTokenManager, 0);
        // Invoke the private method
        Method jjCheckNAddMethod = XPathParserTokenManager.class.getDeclaredMethod("jjCheckNAdd", int.class);
        jjCheckNAddMethod.setAccessible(true);
        jjCheckNAddMethod.invoke(parserTokenManager, state);
        // Validate the state was added
        assertEquals(1, jjnewStateCntField.getInt(parserTokenManager));
        assertEquals(1, jjrounds[state]);
        assertEquals(state, jjstateSet[0]);
    }

    @Test
    public void testJjCheckNAdd_ExistingState() throws Exception {
        // Set up the necessary fields using reflection
        Field jjnewStateCntField = XPathParserTokenManager.class.getDeclaredField("jjnewStateCnt");
        Field jjroundsField = XPathParserTokenManager.class.getDeclaredField("jjrounds");
        Field jjroundField = XPathParserTokenManager.class.getDeclaredField("jjround");
        Field jjstateSetField = XPathParserTokenManager.class.getDeclaredField("jjstateSet");
        jjnewStateCntField.setAccessible(true);
        jjroundsField.setAccessible(true);
        jjroundField.setAccessible(true);
        jjstateSetField.setAccessible(true);
        int state = 0;
        // Set round to 1
        jjroundField.setInt(parserTokenManager, 1);
        int[] jjrounds = (int[]) jjroundsField.get(parserTokenManager);
        // Set previous round to 1
        jjrounds[state] = 1;
        int[] jjstateSet = (int[]) jjstateSetField.get(parserTokenManager);
        // Set new state count to 1
        jjnewStateCntField.setInt(parserTokenManager, 1);
        // Invoke the private method
        Method jjCheckNAddMethod = XPathParserTokenManager.class.getDeclaredMethod("jjCheckNAdd", int.class);
        jjCheckNAddMethod.setAccessible(true);
        jjCheckNAddMethod.invoke(parserTokenManager, state);
        // Validate that the state was not added again
        assertEquals(1, jjnewStateCntField.getInt(parserTokenManager));
    }
}
