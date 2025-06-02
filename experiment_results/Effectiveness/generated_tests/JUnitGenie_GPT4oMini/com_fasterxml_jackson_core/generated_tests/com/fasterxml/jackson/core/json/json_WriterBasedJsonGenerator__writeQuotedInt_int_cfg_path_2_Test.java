package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.StringWriter;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class json_WriterBasedJsonGenerator__writeQuotedInt_int_cfg_path_2_Test {
    private WriterBasedJsonGenerator generator;
    private StringWriter writer;

    @Before
    public void setUp() throws Exception {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, writer, false);
        
        // Initialize the generator with a valid buffer size
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer, '"');
        
        // Initialize the protected fields to meet the constraints
        // Assuming _outputBuffer is initialized with a size of 16
        generator.getClass().getDeclaredField("_outputBuffer").set(generator, new char[16]);
        generator.getClass().getDeclaredField("_outputEnd").set(generator, 16);
        generator.getClass().getDeclaredField("_outputTail").set(generator, 0);
        
        // Initialize the _bufferedWriter to avoid NullPointerException
        generator.getClass().getDeclaredField("_bufferedWriter").set(generator, writer);
    }

    @Test(timeout = 4000)
    public void testWriteQuotedInt() {
        try {
            Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeQuotedInt", int.class);
            method.setAccessible(true);
            
            // Set _outputTail to a value less than _outputEnd to avoid flushing
            generator.getClass().getDeclaredField("_outputTail").set(generator, 0);
            generator.getClass().getDeclaredField("_outputEnd").set(generator, 16);
            
            // Call the method with a sample integer
            method.invoke(generator, 123);
            
            // Verify the output
            char[] expectedOutput = new char[] {'"', '1', '2', '3', '"'};
            char[] actualOutput = writer.toString().toCharArray();
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

}