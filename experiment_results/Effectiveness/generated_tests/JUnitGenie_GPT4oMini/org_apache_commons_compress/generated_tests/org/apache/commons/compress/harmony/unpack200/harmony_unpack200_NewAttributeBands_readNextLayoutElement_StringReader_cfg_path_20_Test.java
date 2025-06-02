package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.NewAttributeBands;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class harmony_unpack200_NewAttributeBands_readNextLayoutElement_StringReader_cfg_path_20_Test {


    private Object invokeReadNextLayoutElement(NewAttributeBands instance, StringReader stream) throws IOException {
        try {
            java.lang.reflect.Method method = NewAttributeBands.class.getDeclaredMethod("readNextLayoutElement", StringReader.class);
            method.setAccessible(true);
            return method.invoke(instance, stream);
        } catch (Exception e) {
            throw new IOException("Failed to invoke readNextLayoutElement", e);
        }
    }


}
