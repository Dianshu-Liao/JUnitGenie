package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.MapperFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_3_Test {

    private static class TestModule extends Module {
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
            // Setup logic for the module can be added here if necessary
        }

        @Override
        public Iterable<Module> getDependencies() {
            return null; // No dependencies for this test module
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleSuccessfully() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule module = new TestModule();
        
        try {
            ObjectMapper result = objectMapper.registerModule(module);
            assertNotNull("The ObjectMapper should be returned after registering the module.", result);
        } catch (Exception e) {
            fail("The module registration should not throw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithNullModuleName() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module moduleWithNullName = new Module() {
            @Override
            public String getModuleName() {
                return null; // Simulating a module without a name
            }

            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null);
            }

            @Override
            public void setupModule(SetupContext context) {}

            @Override
            public Iterable<Module> getDependencies() {
                return null;
            }
        };

        try {
            objectMapper.registerModule(moduleWithNullName);
            fail("Expected IllegalArgumentException was not thrown for module without a defined name");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined name", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithNullVersion() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module moduleWithNullVersion = new Module() {
            @Override
            public String getModuleName() {
                return "TestModule";
            }

            @Override
            public Version version() {
                return null; // Simulating a module without a version
            }

            @Override
            public void setupModule(SetupContext context) {}

            @Override
            public Iterable<Module> getDependencies() {
                return null;
            }
        };

        try {
            objectMapper.registerModule(moduleWithNullVersion);
            fail("Expected IllegalArgumentException was not thrown for module without a defined version");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined version", e.getMessage());
        }
    }

}