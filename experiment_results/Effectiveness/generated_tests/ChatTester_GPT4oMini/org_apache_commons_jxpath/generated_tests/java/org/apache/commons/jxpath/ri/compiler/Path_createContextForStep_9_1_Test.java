package org.apache.commons.jxpath.ri.compiler;

import java.lang.reflect.Method;
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

public class Path_createContextForStep_9_1_Test {

    private Path path;

    private EvalContext context;

    private NodeTest nodeNameTest;

    @BeforeEach
    public void setUp() {
        // Mock dependencies
        context = Mockito.mock(EvalContext.class);
        nodeNameTest = Mockito.mock(NodeNameTest.class);
        path = Mockito.mock(Path.class, Mockito.withSettings().useConstructor(new Step[0]).defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    public void testCreateContextForStepWithNodeNameTestAndNamespace() throws Exception {
        // Given
        QName qname = Mockito.mock(QName.class);
        String prefix = "prefix";
        String namespaceURI = "namespaceURI";
        Mockito.when(nodeNameTest instanceof NodeNameTest).thenReturn(true);
        Mockito.when(((NodeNameTest) nodeNameTest).getNodeName()).thenReturn(qname);
        Mockito.when(qname.getPrefix()).thenReturn(prefix);
        Mockito.when(context.getJXPathContext().getNamespaceURI(prefix)).thenReturn(namespaceURI);
        // When
        Method method = Path.class.getDeclaredMethod("createContextForStep", EvalContext.class, int.class, NodeTest.class);
        method.setAccessible(true);
        Object result = method.invoke(path, context, Compiler.AXIS_CHILD, nodeNameTest);
        // Then
        assertNotNull(result);
        assertTrue(result instanceof ChildContext);
    }

    @Test
    public void testCreateContextForStepWithInvalidAxis() throws Exception {
        // Given
        // When
        Method method = Path.class.getDeclaredMethod("createContextForStep", EvalContext.class, int.class, NodeTest.class);
        method.setAccessible(true);
        // Invalid axis
        Object result = method.invoke(path, context, -1, nodeNameTest);
        // Then
        assertNull(result);
    }

    @Test
    public void testCreateContextForStepWithDifferentAxes() throws Exception {
        // Given
        Method method = Path.class.getDeclaredMethod("createContextForStep", EvalContext.class, int.class, NodeTest.class);
        method.setAccessible(true);
        // Test AXIS_ANCESTOR
        Object resultAncestor = method.invoke(path, context, Compiler.AXIS_ANCESTOR, nodeNameTest);
        assertTrue(resultAncestor instanceof AncestorContext);
        // Test AXIS_ANCESTOR_OR_SELF
        Object resultAncestorOrSelf = method.invoke(path, context, Compiler.AXIS_ANCESTOR_OR_SELF, nodeNameTest);
        assertTrue(resultAncestorOrSelf instanceof AncestorContext);
        // Test AXIS_ATTRIBUTE
        Object resultAttribute = method.invoke(path, context, Compiler.AXIS_ATTRIBUTE, nodeNameTest);
        assertTrue(resultAttribute instanceof AttributeContext);
        // Test AXIS_CHILD
        Object resultChild = method.invoke(path, context, Compiler.AXIS_CHILD, nodeNameTest);
        assertTrue(resultChild instanceof ChildContext);
        // Test AXIS_DESCENDANT
        Object resultDescendant = method.invoke(path, context, Compiler.AXIS_DESCENDANT, nodeNameTest);
        assertTrue(resultDescendant instanceof DescendantContext);
        // Test AXIS_DESCENDANT_OR_SELF
        Object resultDescendantOrSelf = method.invoke(path, context, Compiler.AXIS_DESCENDANT_OR_SELF, nodeNameTest);
        assertTrue(resultDescendantOrSelf instanceof DescendantContext);
        // Test AXIS_FOLLOWING
        Object resultFollowing = method.invoke(path, context, Compiler.AXIS_FOLLOWING, nodeNameTest);
        assertTrue(resultFollowing instanceof PrecedingOrFollowingContext);
        // Test AXIS_FOLLOWING_SIBLING
        Object resultFollowingSibling = method.invoke(path, context, Compiler.AXIS_FOLLOWING_SIBLING, nodeNameTest);
        assertTrue(resultFollowingSibling instanceof ChildContext);
        // Test AXIS_NAMESPACE
        Object resultNamespace = method.invoke(path, context, Compiler.AXIS_NAMESPACE, nodeNameTest);
        assertTrue(resultNamespace instanceof NamespaceContext);
        // Test AXIS_PARENT
        Object resultParent = method.invoke(path, context, Compiler.AXIS_PARENT, nodeNameTest);
        assertTrue(resultParent instanceof ParentContext);
        // Test AXIS_PRECEDING
        Object resultPreceding = method.invoke(path, context, Compiler.AXIS_PRECEDING, nodeNameTest);
        assertTrue(resultPreceding instanceof PrecedingOrFollowingContext);
        // Test AXIS_PRECEDING_SIBLING
        Object resultPrecedingSibling = method.invoke(path, context, Compiler.AXIS_PRECEDING_SIBLING, nodeNameTest);
        assertTrue(resultPrecedingSibling instanceof ChildContext);
    }
}
