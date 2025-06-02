package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Arrange
            InputStream inputStream = System.in; // Example InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 0, 0);
            Method expandBuffMethod = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            expandBuffMethod.setAccessible(true);
            
            // Act
            expandBuffMethod.invoke(charStream, true);
            
            // Assert
            assertNotNull(charStream); // Check that the charStream is not null after invocation
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Arrange
            InputStream inputStream = System.in; // Example InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 0, 0);
            Method expandBuffMethod = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            expandBuffMethod.setAccessible(true);
            
            // Act
            expandBuffMethod.invoke(charStream, false);
            
            // Assert
            assertNotNull(charStream); // Check that the charStream is not null after invocation
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }
    }

}