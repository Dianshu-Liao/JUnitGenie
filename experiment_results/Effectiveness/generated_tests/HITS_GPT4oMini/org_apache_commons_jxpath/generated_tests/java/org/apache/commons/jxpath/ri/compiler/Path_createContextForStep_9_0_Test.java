package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.axes.AncestorContext;
import org.apache.commons.jxpath.ri.axes.AttributeContext;
import org.apache.commons.jxpath.ri.axes.ChildContext;
import org.apache.commons.jxpath.ri.axes.DescendantContext;
import org.apache.commons.jxpath.ri.axes.NamespaceContext;
import org.apache.commons.jxpath.ri.axes.ParentContext;
import org.apache.commons.jxpath.ri.axes.PrecedingOrFollowingContext;
import org.apache.commons.jxpath.ri.axes.SelfContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.PredicateContext;
import org.apache.commons.jxpath.ri.axes.SimplePathInterpreter;
import org.apache.commons.jxpath.ri.axes.UnionContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class Path_createContextForStep_9_0_Test {

    private Path path;

    private EvalContext context;

    @BeforeEach
    public void setUp() {
        path = mock(Path.class);
        context = mock(EvalContext.class);
    }

    @Test
    public void testCreateContextForStep_WhenNodeTestIsNodeNameTest_AndPrefixIsNotNull() {
        // Arrange
        String prefix = "ns";
        String localName = "element";
        QName qname = new QName(prefix, localName);
        NodeNameTest nodeTest = new NodeNameTest(qname);
        when(context.getJXPathContext().getNamespaceURI(prefix)).thenReturn("http://namespace.uri");
        // Act
        EvalContext result = path.createContextForStep(context, Compiler.AXIS_CHILD, nodeTest);
        // Assert
        verify(context.getJXPathContext()).getNamespaceURI(prefix);
        NodeNameTest expectedNodeTest = new NodeNameTest(qname, "http://namespace.uri");
        assert (result instanceof ChildContext);
    }

    @Test
    public void testCreateContextForStep_WhenNodeTestIsNodeNameTest_AndPrefixIsNull() {
        // Arrange
        QName qname = new QName("element");
        NodeNameTest nodeTest = new NodeNameTest(qname);
        // Act
        EvalContext result = path.createContextForStep(context, Compiler.AXIS_CHILD, nodeTest);
        // Assert
        assert (result instanceof ChildContext);
    }

    @Test
    public void testCreateContextForStep_WhenNodeTestIsNotNodeNameTest() {
        // Arrange
        NodeTest nodeTest = mock(NodeTest.class);
        // Act
        EvalContext result = path.createContextForStep(context, Compiler.AXIS_CHILD, nodeTest);
        // Assert
        assert (result instanceof ChildContext);
    }

    @Test
    public void testCreateContextForStep_WithDifferentAxes() {
        // Arrange
        QName qname = new QName("element");
        NodeNameTest nodeTest = new NodeNameTest(qname);
        // Act & Assert for AXIS_ANCESTOR
        EvalContext result = path.createContextForStep(context, Compiler.AXIS_ANCESTOR, nodeTest);
        assert (result instanceof AncestorContext);
        // Act & Assert for AXIS_ATTRIBUTE
        result = path.createContextForStep(context, Compiler.AXIS_ATTRIBUTE, nodeTest);
        assert (result instanceof AttributeContext);
        // Act & Assert for AXIS_DESCENDANT
        result = path.createContextForStep(context, Compiler.AXIS_DESCENDANT, nodeTest);
        assert (result instanceof DescendantContext);
        // Act & Assert for AXIS_PARENT
        result = path.createContextForStep(context, Compiler.AXIS_PARENT, nodeTest);
        assert (result instanceof ParentContext);
        // Act & Assert for AXIS_SELF
        result = path.createContextForStep(context, Compiler.AXIS_SELF, nodeTest);
        assert (result instanceof SelfContext);
    }
}
