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
public class LocationPath_toString_2_0_Test {

    @Mock
    NodeTest nodeTest;

    @Test
    public void testToStringWithNullSteps() {
        LocationPath locationPath = new LocationPath(false, null);
        assertEquals("", locationPath.toString());
    }

    @Test
    public void testToStringWithEmptySteps() {
        Step[] steps = new Step[0];
        LocationPath locationPath = new LocationPath(false, steps);
        assertEquals("", locationPath.toString());
    }

    @Test
    public void testToStringWithSingleStep() {
        Step[] steps = { new Step(0, nodeTest, new Expression[0]) };
        LocationPath locationPath = new LocationPath(false, steps);
        assertEquals("Step", locationPath.toString());
    }

    @Test
    public void testToStringWithMultipleSteps() {
        Step[] steps = { new Step(0, nodeTest, new Expression[0]), new Step(1, nodeTest, new Expression[0]) };
        LocationPath locationPath = new LocationPath(false, steps);
        assertEquals("Step/Step", locationPath.toString());
    }

    @Test
    public void testToStringWithAbsolutePath() {
        Step[] steps = { new Step(0, nodeTest, new Expression[0]), new Step(1, nodeTest, new Expression[0]) };
        LocationPath locationPath = new LocationPath(true, steps);
        assertEquals("Step/Step", locationPath.toString());
    }
}
