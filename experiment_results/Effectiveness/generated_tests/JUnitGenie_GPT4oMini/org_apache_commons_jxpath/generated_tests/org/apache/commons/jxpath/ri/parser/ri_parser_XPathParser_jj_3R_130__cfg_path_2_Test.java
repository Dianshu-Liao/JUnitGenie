package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class ri_parser_XPathParser_jj_3R_130__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testJj_3R_130() {
        try {
            // Create an InputStream with some valid input for the parser
            String input = ""; // Provide a valid input string for the parser
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());

            // Create an instance of XPathParser
            XPathParser parser = new XPathParser(inputStream);

            // Access the private method using reflection
            Method method = XPathParser.class.getDeclaredMethod("jj_3R_130");
            method.setAccessible(true);

            // Set up the necessary conditions for jj_3R_133() and jj_3R_134() to return false
            // This may involve setting up the state of the parser or mocking dependencies

            // Invoke the method
            boolean result = (boolean) method.invoke(parser);

            // Assert that the result is false as per the constraints
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

}