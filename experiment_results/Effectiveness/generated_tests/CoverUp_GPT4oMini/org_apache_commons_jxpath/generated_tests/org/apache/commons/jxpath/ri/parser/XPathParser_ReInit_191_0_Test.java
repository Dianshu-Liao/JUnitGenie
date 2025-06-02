package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import java.io.StringReader;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;

public class XPathParser_ReInit_191_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    private SimpleCharStream charStream;

    @BeforeEach
    public void setUp() {
        tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("")));
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testReInit() throws Exception {
        String testInput = "test input";
        StringReader reader = new StringReader(testInput);
        // Invoke the private method using reflection
        Field streamField = XPathParser.class.getDeclaredField("jj_input_stream");
        streamField.setAccessible(true);
        // Call the ReInit method
        parser.ReInit(reader);
        // Verify that the jj_input_stream is initialized
        SimpleCharStream inputStream = (SimpleCharStream) streamField.get(parser);
        assertNotNull(inputStream);
    }

    @Test
    public void testReInitWithTokenSource() throws Exception {
        String testInput = "another test input";
        StringReader reader = new StringReader(testInput);
        // Invoke the ReInit method
        parser.ReInit(reader);
        // Verify that token_source is initialized
        Field tokenSourceField = XPathParser.class.getDeclaredField("token_source");
        tokenSourceField.setAccessible(true);
        XPathParserTokenManager tokenSource = (XPathParserTokenManager) tokenSourceField.get(parser);
        assertNotNull(tokenSource);
    }

    @Test
    public void testReInitResetsState() throws Exception {
        String initialInput = "initial input";
        StringReader initialReader = new StringReader(initialInput);
        parser.ReInit(initialReader);
        // Set some state in the parser
        Field jj_genField = XPathParser.class.getDeclaredField("jj_gen");
        jj_genField.setAccessible(true);
        jj_genField.setInt(parser, 5);
        // Reinitialize with new input
        String newInput = "new input";
        StringReader newReader = new StringReader(newInput);
        parser.ReInit(newReader);
        // Verify that the state has been reset
        int jj_gen = jj_genField.getInt(parser);
        assertNotNull(jj_gen);
        // Ensure it has changed
        assertNotEquals(5, jj_gen);
    }
}
