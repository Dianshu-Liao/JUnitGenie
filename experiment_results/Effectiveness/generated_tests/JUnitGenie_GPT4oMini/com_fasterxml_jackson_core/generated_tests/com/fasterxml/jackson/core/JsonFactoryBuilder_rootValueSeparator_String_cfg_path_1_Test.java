package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.io.SerializedString;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class JsonFactoryBuilder_rootValueSeparator_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRootValueSeparator() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        String separator = "separator"; // Valid string input

        // Execute the focal method
        builder.rootValueSeparator(separator);

        // Validate that _rootValueSeparator is not null after setting a valid separator
        assertNotNull(builder._rootValueSeparator);
    }

    @Test(timeout = 4000)
    public void testRootValueSeparatorWithNull() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        String separator = null; // Null input

        // Execute the focal method
        builder.rootValueSeparator(separator);

        // Validate that _rootValueSeparator is null after setting a null separator
        assertNull(builder._rootValueSeparator); // Now assertNull is correctly imported
    }


}