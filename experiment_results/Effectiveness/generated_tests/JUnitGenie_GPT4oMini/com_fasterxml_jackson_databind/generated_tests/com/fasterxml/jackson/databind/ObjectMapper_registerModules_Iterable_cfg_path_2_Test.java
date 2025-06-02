package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collections;

public class ObjectMapper_registerModules_Iterable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRegisterModules_NonNullModules() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return "TestModule";
            }

            @Override
            public Version version() {
                return Version.unknownVersion();
            }

            @Override
            public void setupModule(SetupContext context) {
                // Setup logic for the module
            }
        };
        
        Iterable<Module> modules = Collections.singletonList(module);
        ObjectMapper result = objectMapper.registerModules(modules);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testRegisterModules_NullModules() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.registerModules((Module[]) null); // Cast to Module[] to resolve ambiguity
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("modules", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModules_EmptyModules() {
        ObjectMapper objectMapper = new ObjectMapper();
        Iterable<Module> modules = Collections.emptyList();
        ObjectMapper result = objectMapper.registerModules(modules);
        assertNotNull(result);
    }


}