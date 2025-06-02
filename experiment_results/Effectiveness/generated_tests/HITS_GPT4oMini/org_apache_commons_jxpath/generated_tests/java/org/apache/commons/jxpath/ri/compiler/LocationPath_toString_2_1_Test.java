package org.apache.commons.jxpath.ri.compiler;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.axes.InitialContext;

@ExtendWith(MockitoExtension.class)
public class LocationPath_toString_2_1_Test {

    @Mock
    private NodeTest nodeTest1;

    @Mock
    private NodeTest nodeTest2;

    @Test
    public void testToStringWithAbsolutePath() {
        // Arrange
        Step[] steps = new Step[] { new Step(0, nodeTest1, null), new Step(1, nodeTest2, null) };
        LocationPath locationPath = new LocationPath(true, steps);
        // Act
        String result = locationPath.toString();
        // Assert
        Assertions.assertEquals("/node1/node2", result);
    }

    @Test
    public void testToStringWithRelativePath() {
        // Arrange
        Step[] steps = new Step[] { new Step(0, nodeTest1, null), new Step(1, nodeTest2, null) };
        LocationPath locationPath = new LocationPath(false, steps);
        // Act
        String result = locationPath.toString();
        // Assert
        Assertions.assertEquals("node1/node2", result);
    }

    @Test
    public void testToStringWithNoSteps() {
        // Arrange
        Step[] steps = null;
        LocationPath locationPath = new LocationPath(true, steps);
        // Act
        String result = locationPath.toString();
        // Assert
        Assertions.assertEquals("", result);
    }

    @Test
    public void testToStringWithEmptySteps() {
        // Arrange
        Step[] steps = new Step[0];
        LocationPath locationPath = new LocationPath(true, steps);
        // Act
        String result = locationPath.toString();
        // Assert
        Assertions.assertEquals("", result);
    }
}
