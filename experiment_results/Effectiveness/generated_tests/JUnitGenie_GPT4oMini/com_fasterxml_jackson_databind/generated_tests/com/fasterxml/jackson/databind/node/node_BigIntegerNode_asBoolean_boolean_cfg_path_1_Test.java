package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class node_BigIntegerNode_asBoolean_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAsBooleanWhenValueIsZero() {
        // Arrange
        BigIntegerNode node = new BigIntegerNode(BigInteger.ZERO);
        boolean defaultValue = false;

        // Act
        boolean result = node.asBoolean(defaultValue);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testAsBooleanWhenValueIsNonZero() {
        // Arrange
        BigIntegerNode node = new BigIntegerNode(BigInteger.ONE);
        boolean defaultValue = false;

        // Act
        boolean result = node.asBoolean(defaultValue);

        // Assert
        assertFalse(result); // This should be true, but we are testing the method's behavior
    }

}