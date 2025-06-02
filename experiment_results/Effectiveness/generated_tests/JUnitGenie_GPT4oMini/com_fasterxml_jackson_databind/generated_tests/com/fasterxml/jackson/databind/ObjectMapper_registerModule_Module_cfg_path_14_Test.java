package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_14_Test {

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
            // Setup logic for the module can be added here if needed
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule module = new TestModule();

        try {
            ObjectMapper result = objectMapper.registerModule(module);
            assertNotNull(result);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown IllegalArgumentException: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithNullName() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return null; // This should trigger the exception
            }

            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null);
            }

            @Override
            public void setupModule(SetupContext context) {
                // Setup logic for the module can be added here if needed
            }
        };

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException for module without defined name");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined name", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithNullVersion() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return "TestModule";
            }

            @Override
            public Version version() {
                return null; // This should trigger the exception
            }

            @Override
            public void setupModule(SetupContext context) {
                // Setup logic for the module can be added here if needed
            }
        };

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException for module without defined version");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined version", e.getMessage());
        }
    }

}