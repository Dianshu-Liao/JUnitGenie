package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.BooleanNode;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class node_BooleanNode_readResolve__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadResolveReturnsFalse() {
        try {
            // Create an instance of BooleanNode with _value set to false
            BooleanNode booleanNode = new BooleanNode(false);
            
            // Access the protected method readResolve using reflection
            Method method = BooleanNode.class.getDeclaredMethod("readResolve");
            method.setAccessible(true);
            
            // Invoke the method and assert the result
            Object result = method.invoke(booleanNode);
            assertEquals(BooleanNode.FALSE, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}