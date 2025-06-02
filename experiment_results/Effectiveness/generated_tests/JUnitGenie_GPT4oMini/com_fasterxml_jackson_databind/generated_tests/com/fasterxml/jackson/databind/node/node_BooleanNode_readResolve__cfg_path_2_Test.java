package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.BooleanNode;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class node_BooleanNode_readResolve__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadResolveTrue() {
        try {
            // Create an instance of BooleanNode with _value set to true
            BooleanNode booleanNode = (BooleanNode) BooleanNode.class.getDeclaredConstructor(boolean.class).newInstance(true);
            
            // Access the protected method readResolve using reflection
            Method readResolveMethod = BooleanNode.class.getDeclaredMethod("readResolve");
            readResolveMethod.setAccessible(true);
            
            // Invoke the method and assert the result
            Object result = readResolveMethod.invoke(booleanNode);
            assertEquals(BooleanNode.TRUE, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadResolveFalse() {
        try {
            // Create an instance of BooleanNode with _value set to false
            BooleanNode booleanNode = (BooleanNode) BooleanNode.class.getDeclaredConstructor(boolean.class).newInstance(false);
            
            // Access the protected method readResolve using reflection
            Method readResolveMethod = BooleanNode.class.getDeclaredMethod("readResolve");
            readResolveMethod.setAccessible(true);
            
            // Invoke the method and assert the result
            Object result = readResolveMethod.invoke(booleanNode);
            assertEquals(BooleanNode.FALSE, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}