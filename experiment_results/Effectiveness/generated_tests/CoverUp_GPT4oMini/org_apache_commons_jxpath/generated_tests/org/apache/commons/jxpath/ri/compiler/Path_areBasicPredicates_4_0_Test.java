package org.apache.commons.jxpath.ri.compiler;

import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.Path;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.Compiler;
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

class Path_areBasicPredicates_4_0_Test {

    private static class TestPath extends Path {

        public TestPath(Step[] steps) {
            super(steps);
        }

        @Override
        public NodePointer compute(EvalContext context) {
            // This is just a stub for the abstract method
            return null;
        }

        // Added the required computeValue method
        @Override
        public Object computeValue(EvalContext context) {
            // Stub implementation
            return null;
        }
    }

    @Test
    void testAreBasicPredicates_WithNullPredicates() throws Exception {
        Path path = new TestPath(new Step[0]);
        Method method = Path.class.getDeclaredMethod("areBasicPredicates", Expression[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(path, (Object) null);
        assertTrue(result);
    }

    @Test
    void testAreBasicPredicates_WithEmptyPredicates() throws Exception {
        Path path = new TestPath(new Step[0]);
        Method method = Path.class.getDeclaredMethod("areBasicPredicates", Expression[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(path, new Expression[] {});
        assertTrue(result);
    }

    @Test
    void testAreBasicPredicates_WithBasicPredicates() throws Exception {
        Path path = new TestPath(new Step[0]);
        Expression[] predicates = new Expression[] { Mockito.mock(NameAttributeTest.class), Mockito.mock(NameAttributeTest.class) };
        // Mocking behavior
        Mockito.when(((NameAttributeTest) predicates[0]).getNameTestExpression()).thenReturn(Mockito.mock(Expression.class));
        Mockito.when(((NameAttributeTest) predicates[0]).getNameTestExpression().isContextDependent()).thenReturn(false);
        Mockito.when(predicates[1].isContextDependent()).thenReturn(false);
        Method method = Path.class.getDeclaredMethod("areBasicPredicates", Expression[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(path, new Object[] { predicates });
        assertTrue(result);
    }

    @Test
    void testAreBasicPredicates_WithContextDependentPredicate() throws Exception {
        Path path = new TestPath(new Step[0]);
        Expression[] predicates = new Expression[] { Mockito.mock(NameAttributeTest.class) };
        // Mocking behavior
        Mockito.when(((NameAttributeTest) predicates[0]).getNameTestExpression()).thenReturn(Mockito.mock(Expression.class));
        Mockito.when(((NameAttributeTest) predicates[0]).getNameTestExpression().isContextDependent()).thenReturn(true);
        Method method = Path.class.getDeclaredMethod("areBasicPredicates", Expression[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(path, new Object[] { predicates });
        assertFalse(result);
    }

    @Test
    void testAreBasicPredicates_WithNonBasicPredicate() throws Exception {
        Path path = new TestPath(new Step[0]);
        Expression[] predicates = new Expression[] { Mockito.mock(Expression.class), Mockito.mock(NameAttributeTest.class) };
        // Mocking behavior
        Mockito.when(predicates[0].isContextDependent()).thenReturn(true);
        Method method = Path.class.getDeclaredMethod("areBasicPredicates", Expression[].class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(path, new Object[] { predicates });
        assertFalse(result);
    }
}
