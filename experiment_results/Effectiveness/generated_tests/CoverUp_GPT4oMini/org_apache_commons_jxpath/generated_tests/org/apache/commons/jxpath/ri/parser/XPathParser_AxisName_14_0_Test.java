package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.apache.commons.jxpath.ri.parser.Token;
import org.apache.commons.jxpath.ri.parser.ParseException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;

public class XPathParser_AxisName_14_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    private Token token;

    @BeforeEach
    public void setUp() {
        InputStream inputStream = new ByteArrayInputStream("dummy input".getBytes());
        parser = new XPathParser(inputStream);
        tokenManager = Mockito.mock(XPathParserTokenManager.class);
        parser.token_source = tokenManager;
        token = new Token();
        parser.token = token;
        parser.jj_nt = token;
    }

    @Test
    public void testAxisName_AxisSelf() throws ParseException {
        token.kind = Compiler.AXIS_SELF;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_SELF, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisChild() throws ParseException {
        token.kind = Compiler.AXIS_CHILD;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_CHILD, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisParent() throws ParseException {
        token.kind = Compiler.AXIS_PARENT;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_PARENT, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisAncestor() throws ParseException {
        token.kind = Compiler.AXIS_ANCESTOR;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_ANCESTOR, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisAttribute() throws ParseException {
        token.kind = Compiler.AXIS_ATTRIBUTE;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_ATTRIBUTE, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisNamespace() throws ParseException {
        token.kind = Compiler.AXIS_NAMESPACE;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_NAMESPACE, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisPreceding() throws ParseException {
        token.kind = Compiler.AXIS_PRECEDING;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_PRECEDING, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisFollowing() throws ParseException {
        token.kind = Compiler.AXIS_FOLLOWING;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_FOLLOWING, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisDescendant() throws ParseException {
        token.kind = Compiler.AXIS_DESCENDANT;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_DESCENDANT, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisAncestorOrSelf() throws ParseException {
        token.kind = Compiler.AXIS_ANCESTOR_OR_SELF;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_ANCESTOR_OR_SELF, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisFollowingSibling() throws ParseException {
        token.kind = Compiler.AXIS_FOLLOWING_SIBLING;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_FOLLOWING_SIBLING, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisPrecedingSibling() throws ParseException {
        token.kind = Compiler.AXIS_PRECEDING_SIBLING;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        assertEquals(Compiler.AXIS_PRECEDING_SIBLING, parser.AxisName());
    }

    @Test
    public void testAxisName_AxisDescendantOrSelf() throws ParseException {
        token.kind = Compiler.AXIS_DESCENDANT_OR_SELF;
    }
}
