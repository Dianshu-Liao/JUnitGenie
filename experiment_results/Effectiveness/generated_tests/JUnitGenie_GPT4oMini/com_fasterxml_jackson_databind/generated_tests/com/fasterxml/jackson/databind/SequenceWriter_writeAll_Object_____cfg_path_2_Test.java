package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.Test;
import java.io.IOException;

public class SequenceWriter_writeAll_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteAll_withEmptyArray() throws IOException {
        JsonMapper mapper = JsonMapper.builder().build();
        JsonGenerator generator = mapper.getFactory().createGenerator(System.out);
        SequenceWriter writer = mapper.writer().writeValues(generator);
        
        try {
            writer.writeAll(new Object[] {});
        } finally {
            generator.close();
        }
    }

    @Test(timeout = 4000)
    public void testWriteAll_withNonEmptyArray() throws IOException {
        JsonMapper mapper = JsonMapper.builder().build();
        JsonGenerator generator = mapper.getFactory().createGenerator(System.out);
        SequenceWriter writer = mapper.writer().writeValues(generator);
        
        try {
            writer.writeAll(new Object[] { "value1", "value2", "value3" });
        } finally {
            generator.close();
        }
    }

    // Additional tests can be added here to further explore different scenarios


}