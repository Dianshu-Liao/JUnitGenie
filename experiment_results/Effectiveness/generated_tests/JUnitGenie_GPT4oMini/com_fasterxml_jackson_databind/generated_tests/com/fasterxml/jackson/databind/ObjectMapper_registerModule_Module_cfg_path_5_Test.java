package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_5_Test {

    private static class TestModule extends Module {
        @Override
        public String getModuleName() {
            return "TestModule"; // Provide a valid module name to avoid IllegalArgumentException
        }

        @Override
        public Version version() {
            return new Version(1, 0, 0, null, null, null);
        }

        @Override
        public void setupModule(SetupContext context) {
            // Setup logic can be added here if needed
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule_NullModuleName() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule module = new TestModule();

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException for module without defined name");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined name", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule_ValidModule() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return "TestModule";
            }

            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null);
            }

            @Override
            public void setupModule(SetupContext context) {
                // Setup logic can be added here if needed
            }
        };

        objectMapper.registerModule(module);
        // Additional assertions can be added to verify the module registration
    }

    @Test(timeout = 4000)
    public void testRegisterModule_WithDependencies() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module moduleWithDependency = new Module() {
            @Override
            public String getModuleName() {
                return "ModuleWithDependency";
            }

            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null);
            }

            @Override
            public void setupModule(SetupContext context) {
                // Setup logic can be added here if needed
            }

            @Override
            public Iterable<Module> getDependencies() {
                return java.util.Collections.singletonList(new TestModule());
            }
        };

        objectMapper.registerModule(moduleWithDependency);
        // Additional assertions can be added to verify the module registration
    }


}