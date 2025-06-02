package org.apache.commons.jxpath.ri.parser;

import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_ReInit_191_0_Test {

    private XPathParser parser;

    private Reader reader;

    @BeforeEach
    public void setUp() {
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(new StringReader("sample input"))));
        reader = new StringReader("sample input");
    }

    @Test
    public void testReInit() throws Exception {
        // Invoke the ReInit method using reflection
        Method reInitMethod = XPathParser.class.getDeclaredMethod("ReInit", Reader.class);
        reInitMethod.setAccessible(true);
        // Call the method with the reader
        reInitMethod.invoke(parser, reader);
        // Verify the state of the parser after initialization
        assertNotNull(parser.token_source);
        assertNotNull(parser.jj_input_stream);
        assertNotNull(parser.token);
        assertNotNull(parser.jj_nt);
        // Accessing jj_gen via reflection
        Field jjGenField = XPathParser.class.getDeclaredField("jj_gen");
        jjGenField.setAccessible(true);
        assertEquals(0, jjGenField.getInt(parser));
        // Accessing jj_la via reflection
        Field jjLaField = XPathParser.class.getDeclaredField("jj_la");
        jjLaField.setAccessible(true);
        int[] jj_la = (int[]) jjLaField.get(parser);
        assertEquals(-1, jj_la[0]);
        // Accessing jj_2_rtns via reflection
        Field jj2RtnsField = XPathParser.class.getDeclaredField("jj_2_rtns");
        jj2RtnsField.setAccessible(true);
        assertNotNull(jj2RtnsField.get(parser));
    }

    @Test
    public void testReInitWithDifferentInput() throws Exception {
        Reader newReader = new StringReader("different input");
        Method reInitMethod = XPathParser.class.getDeclaredMethod("ReInit", Reader.class);
        reInitMethod.setAccessible(true);
        // Call the method with the new reader
        reInitMethod.invoke(parser, newReader);
        // Verify the state of the parser after re-initialization
        assertNotNull(parser.token_source);
        assertNotNull(parser.jj_input_stream);
        assertNotNull(parser.token);
        assertNotNull(parser.jj_nt);
        // Accessing jj_gen via reflection
        Field jjGenField = XPathParser.class.getDeclaredField("jj_gen");
        jjGenField.setAccessible(true);
        assertEquals(0, jjGenField.getInt(parser));
        // Accessing jj_la via reflection
        Field jjLaField = XPathParser.class.getDeclaredField("jj_la");
        jjLaField.setAccessible(true);
        int[] jj_la = (int[]) jjLaField.get(parser);
        assertEquals(-1, jj_la[0]);
        // Accessing jj_2_rtns via reflection
        Field jj2RtnsField = XPathParser.class.getDeclaredField("jj_2_rtns");
        jj2RtnsField.setAccessible(true);
        assertNotNull(jj2RtnsField.get(parser));
    }

    @Test
    public void testReInitStateReset() throws Exception {
        Method reInitMethod = XPathParser.class.getDeclaredMethod("ReInit", Reader.class);
        reInitMethod.setAccessible(true);
        reInitMethod.invoke(parser, reader);
        // Accessing jj_gen via reflection
        Field jjGenField = XPathParser.class.getDeclaredField("jj_gen");
        jjGenField.setAccessible(true);
        int initialGen = jjGenField.getInt(parser);
        // Re-initialize
        reInitMethod.invoke(parser, reader);
        // Verify that jj_gen has been reset
        assertEquals(0, jjGenField.getInt(parser));
        assertNotEquals(initialGen, jjGenField.getInt(parser));
    }

    @Test
    public void testReInitWithNullReader() throws Exception {
        Method reInitMethod = XPathParser.class.getDeclaredMethod("ReInit", Reader.class);
        reInitMethod.setAccessible(true);
        // Call the method with null reader and expect an exception
        Exception exception = assertThrows(NullPointerException.class, () -> {
            reInitMethod.invoke(parser, (Reader) null);
        });
        assertNotNull(exception);
    }
}
