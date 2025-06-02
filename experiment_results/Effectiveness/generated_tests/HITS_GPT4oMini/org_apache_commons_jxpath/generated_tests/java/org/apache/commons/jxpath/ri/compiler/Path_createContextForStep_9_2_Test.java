package org.apache.commons.jxpath.ri.compiler;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
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

public class Path_createContextForStep_9_2_Test {

    private Path path;

    private EvalContext evalContext;

    private NodeTest nodeNameTest;

    @BeforeEach
    public void setUp() {
        // Initialize the Path instance and the dependencies
        path = Mockito.mock(Path.class, Mockito.withSettings().useConstructor().defaultAnswer(Mockito.CALLS_REAL_METHODS));
        evalContext = Mockito.mock(EvalContext.class);
        QName qname = new QName("prefix", "localName");
        nodeNameTest = new NodeNameTest(qname);
    }

    @Test
    public void testCreateContextForStep_Ancestor() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_ANCESTOR, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof AncestorContext);
    }

    @Test
    public void testCreateContextForStep_AncestorOrSelf() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_ANCESTOR_OR_SELF, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof AncestorContext);
    }

    @Test
    public void testCreateContextForStep_Attribute() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_ATTRIBUTE, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof AttributeContext);
    }

    @Test
    public void testCreateContextForStep_Child() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_CHILD, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof ChildContext);
    }

    @Test
    public void testCreateContextForStep_Descendant() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_DESCENDANT, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof DescendantContext);
    }

    @Test
    public void testCreateContextForStep_DescendantOrSelf() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_DESCENDANT_OR_SELF, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof DescendantContext);
    }

    @Test
    public void testCreateContextForStep_Following() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_FOLLOWING, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof PrecedingOrFollowingContext);
    }

    @Test
    public void testCreateContextForStep_FollowingSibling() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_FOLLOWING_SIBLING, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof ChildContext);
    }

    @Test
    public void testCreateContextForStep_Namespace() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_NAMESPACE, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof NamespaceContext);
    }

    @Test
    public void testCreateContextForStep_Parent() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_PARENT, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof ParentContext);
    }

    @Test
    public void testCreateContextForStep_Preceding() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_PRECEDING, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof PrecedingOrFollowingContext);
    }

    @Test
    public void testCreateContextForStep_PrecedingSibling() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_PRECEDING_SIBLING, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof ChildContext);
    }

    @Test
    public void testCreateContextForStep_Self() {
        EvalContext context = path.createContextForStep(evalContext, Compiler.AXIS_SELF, nodeNameTest);
        assertNotNull(context);
        assertTrue(context instanceof SelfContext);
    }

    @Test
    public void testCreateContextForStep_InvalidAxis() {
        EvalContext context = path.createContextForStep(evalContext, -1, nodeNameTest);
        assertNull(context);
    }
}
