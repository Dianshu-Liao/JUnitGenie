package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.compiler.Step;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.axes.AncestorContext;
import org.apache.commons.jxpath.ri.axes.AttributeContext;
import org.apache.commons.jxpath.ri.axes.ChildContext;
import org.apache.commons.jxpath.ri.axes.DescendantContext;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.NamespaceContext;
import org.apache.commons.jxpath.ri.axes.ParentContext;
import org.apache.commons.jxpath.ri.axes.PrecedingOrFollowingContext;
import org.apache.commons.jxpath.ri.axes.PredicateContext;
import org.apache.commons.jxpath.ri.axes.SelfContext;
import org.apache.commons.jxpath.ri.axes.SimplePathInterpreter;
import org.apache.commons.jxpath.ri.axes.UnionContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

class Path_isSimpleStep_3_0_Test extends Path {

    public Path_isSimpleStep_3_0_Test() {
        super(new Step[0]);
    }

    @Override
    public Pointer compute(EvalContext context) {
        // Implement as needed for the test
        return null;
    }

    @Override
    public Object computeValue(EvalContext context) {
        // Implement as needed for the test
        return null;
    }

    @Test
    void testIsSimpleStepSelfAxisWithNodeTypeTest() {
        NodeTypeTest nodeTypeTest = new NodeTypeTest(Compiler.NODE_TYPE_NODE);
        Step step = new Step(Compiler.AXIS_SELF, nodeTypeTest, null);
        assertTrue(invokeIsSimpleStep(step));
    }

    @Test
    void testIsSimpleStepSelfAxisWithNonNodeTypeTest() {
        NodeNameTest nodeNameTest = new NodeNameTest(new QName("test"));
        Step step = new Step(Compiler.AXIS_SELF, nodeNameTest, null);
        assertFalse(invokeIsSimpleStep(step));
    }

    @Test
    void testIsSimpleStepChildAxisWithNodeNameTest() {
        NodeNameTest nodeNameTest = new NodeNameTest(new QName("test"));
        Step step = new Step(Compiler.AXIS_CHILD, nodeNameTest, null);
        assertTrue(invokeIsSimpleStep(step));
    }

    @Test
    void testIsSimpleStepChildAxisWithWildcard() {
        NodeNameTest nodeNameTest = new NodeNameTest(new QName("*"));
        Step step = new Step(Compiler.AXIS_CHILD, nodeNameTest, null);
        assertFalse(invokeIsSimpleStep(step));
    }

    @Test
    void testIsSimpleStepAttributeAxisWithNodeNameTest() {
        NodeNameTest nodeNameTest = new NodeNameTest(new QName("test"));
        Step step = new Step(Compiler.AXIS_ATTRIBUTE, nodeNameTest, null);
        assertTrue(invokeIsSimpleStep(step));
    }

    @Test
    void testIsSimpleStepAttributeAxisWithWildcard() {
        NodeNameTest nodeNameTest = new NodeNameTest(new QName("*"));
        Step step = new Step(Compiler.AXIS_ATTRIBUTE, nodeNameTest, null);
        assertFalse(invokeIsSimpleStep(step));
    }

    @Test
    void testIsSimpleStepWithNonSimpleAxis() {
        Step step = new Step(99, null, null);
        assertFalse(invokeIsSimpleStep(step));
    }

    private boolean invokeIsSimpleStep(Step step) {
        try {
            Method method = Path.class.getDeclaredMethod("isSimpleStep", Step.class);
            method.setAccessible(true);
            return (boolean) method.invoke(this, step);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
