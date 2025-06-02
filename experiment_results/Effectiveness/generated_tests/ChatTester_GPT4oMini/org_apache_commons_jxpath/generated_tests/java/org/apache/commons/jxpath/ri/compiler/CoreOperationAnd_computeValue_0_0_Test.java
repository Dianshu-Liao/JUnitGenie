package org.apache.commons.jxpath.ri.compiler;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;

public class CoreOperationAnd_computeValue_0_0_Test {

    private CoreOperationAnd coreOperationAnd;

    private Expression[] mockExpressions;

    private EvalContext mockContext;

    @BeforeEach
    public void setUp() {
        // Create mock expressions and context
        mockExpressions = new Expression[3];
        for (int i = 0; i < mockExpressions.length; i++) {
            mockExpressions[i] = mock(Expression.class);
        }
        mockContext = mock(EvalContext.class);
        // Initialize the CoreOperationAnd with mock expressions
        coreOperationAnd = new CoreOperationAnd(mockExpressions);
    }

    @Test
    public void testComputeValue_AllTrue() {
        // Arrange
        when(mockExpressions[0].computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpressions[1].computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpressions[2].computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(InfoSetUtil.booleanValue(Boolean.TRUE)).thenReturn(true);
        // Act
        Object result = coreOperationAnd.computeValue(mockContext);
        // Assert
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testComputeValue_OneFalse() {
        // Arrange
        when(mockExpressions[0].computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpressions[1].computeValue(mockContext)).thenReturn(Boolean.FALSE);
        when(mockExpressions[2].computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(InfoSetUtil.booleanValue(Boolean.TRUE)).thenReturn(true);
        when(InfoSetUtil.booleanValue(Boolean.FALSE)).thenReturn(false);
        // Act
        Object result = coreOperationAnd.computeValue(mockContext);
        // Assert
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testComputeValue_AllFalse() {
        // Arrange
        when(mockExpressions[0].computeValue(mockContext)).thenReturn(Boolean.FALSE);
        when(mockExpressions[1].computeValue(mockContext)).thenReturn(Boolean.FALSE);
        when(mockExpressions[2].computeValue(mockContext)).thenReturn(Boolean.FALSE);
        when(InfoSetUtil.booleanValue(Boolean.FALSE)).thenReturn(false);
        // Act
        Object result = coreOperationAnd.computeValue(mockContext);
        // Assert
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testComputeValue_MixedResults() {
        // Arrange
        when(mockExpressions[0].computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpressions[1].computeValue(mockContext)).thenReturn(Boolean.TRUE);
        when(mockExpressions[2].computeValue(mockContext)).thenReturn(Boolean.FALSE);
        when(InfoSetUtil.booleanValue(Boolean.TRUE)).thenReturn(true);
        when(InfoSetUtil.booleanValue(Boolean.FALSE)).thenReturn(false);
        // Act
        Object result = coreOperationAnd.computeValue(mockContext);
        // Assert
        assertEquals(Boolean.FALSE, result);
    }
}
