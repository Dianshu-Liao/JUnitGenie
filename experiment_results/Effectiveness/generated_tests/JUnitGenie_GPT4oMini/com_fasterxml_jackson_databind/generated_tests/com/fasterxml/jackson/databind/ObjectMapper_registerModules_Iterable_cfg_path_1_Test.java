package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModules_Iterable_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRegisterModules() {
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Create a mock Module that satisfies the constraints
        Module mockModule = new Module() {
            @Override
            public String getModuleName() {
                return "TestModule"; // Non-null String
            }

            @Override
            public Version version() {
                return Version.unknownVersion();
            }

            @Override
            public void setupModule(Module.SetupContext context) {
                // Setup logic for the module
            }
        };

        // Create an Iterable of Modules
        Iterable<Module> modules = java.util.Collections.singletonList(mockModule);

        // Call the focal method
        ObjectMapper result = objectMapper.registerModules(modules);

        // Verify that the result is the same instance
        assertSame(objectMapper, result);
    }

    @Test(timeout = 4000)
    public void testRegisterModulesWithNull() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.registerModules((Module[]) null); // Cast to Module[] to resolve ambiguity
            fail("Expected an exception to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("modules", e.getMessage());
        }
    }


}