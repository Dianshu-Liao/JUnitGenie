package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class node_BigIntegerNode_asBoolean_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAsBooleanWhenValueIsNotZero() {
        // Arrange
        BigIntegerNode node = new BigIntegerNode(BigInteger.ONE); // _value is set to a non-zero BigInteger

        // Act
        boolean result = node.asBoolean(false);

        // Assert
        assertTrue(result); // Expecting true since _value is not zero
    }

    @Test(timeout = 4000)
    public void testAsBooleanWhenValueIsZero() {
        // Arrange
        BigIntegerNode node = new BigIntegerNode(BigInteger.ZERO); // _value is set to zero

        // Act
        boolean result = node.asBoolean(false);

        // Assert
        assertTrue(!result); // Expecting false since _value is zero
    }

}