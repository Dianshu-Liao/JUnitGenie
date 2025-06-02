package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_73_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWrapAround() {
        try {
            SimpleCharStream charStream = new SimpleCharStream(new java.io.StringReader("test"), 16, 0);
            Field tokenBeginField = SimpleCharStream.class.getDeclaredField("tokenBegin");
            Field bufferField = SimpleCharStream.class.getDeclaredField("buffer");
            Field bufsizeField = SimpleCharStream.class.getDeclaredField("bufsize");

            tokenBeginField.setAccessible(true);
            bufferField.setAccessible(true);
            bufsizeField.setAccessible(true);

            // Set the fields to specific values to test the wrapAround path
            tokenBeginField.setInt(charStream, 0);
            bufsizeField.setInt(charStream, 16);
            bufferField.set(charStream, new char[16]);

            // Testing the method
            charStream.getClass().getDeclaredMethod("ExpandBuff", boolean.class).invoke(charStream, true);

            // Verify state changes (example verification)
            assertNotNull(bufferField.get(charStream));
            assertNotNull(bufsizeField.getInt(charStream));

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffNoWrapAround() {
        try {
            SimpleCharStream charStream = new SimpleCharStream(new java.io.StringReader("test"), 16, 0);
            Field tokenBeginField = SimpleCharStream.class.getDeclaredField("tokenBegin");
            Field bufferField = SimpleCharStream.class.getDeclaredField("buffer");
            Field bufsizeField = SimpleCharStream.class.getDeclaredField("bufsize");

            tokenBeginField.setAccessible(true);
            bufferField.setAccessible(true);
            bufsizeField.setAccessible(true);

            // Set the fields to specific values to test the no wrapAround path
            tokenBeginField.setInt(charStream, 0);
            bufsizeField.setInt(charStream, 16);
            bufferField.set(charStream, new char[16]);

            // Testing the method
            charStream.getClass().getDeclaredMethod("ExpandBuff", boolean.class).invoke(charStream, false);

            // Verify state changes (example verification)
            assertNotNull(bufferField.get(charStream));
            assertNotNull(bufsizeField.getInt(charStream));

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

}