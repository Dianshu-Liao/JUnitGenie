package com.fasterxml.jackson.databind.node;
import com.fasterxml.jackson.databind.node.DecimalNode;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class node_DecimalNode_canConvertToLong__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCanConvertToLong_ValidValue() {
        try {
            // Arrange
            BigDecimal valueInRange = BigDecimal.valueOf(0); // Example value within the range
            DecimalNode decimalNode = new DecimalNode(valueInRange);

            // Act
            boolean result = decimalNode.canConvertToLong();

            // Assert
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace(); // Handling the exception as per the instruction
        }
    }

}