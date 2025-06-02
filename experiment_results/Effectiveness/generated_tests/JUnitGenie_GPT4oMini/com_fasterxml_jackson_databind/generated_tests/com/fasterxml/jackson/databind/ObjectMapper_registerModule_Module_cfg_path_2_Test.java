package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_2_Test {

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
    public void testRegisterModule_throwsIllegalArgumentException_whenModuleNameIsNull() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return null; // Simulating a module without a name
            }

            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null);
            }

            @Override
            public void setupModule(SetupContext context) {
                // No setup needed for this test
            }
        };

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined name", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule_throwsIllegalArgumentException_whenVersionIsNull() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return "ValidModule"; // Valid name
            }

            @Override
            public Version version() {
                return null; // Simulating a module without a version
            }

            @Override
            public void setupModule(SetupContext context) {
                // No setup needed for this test
            }
        };

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined version", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule_success() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new TestModule();

        ObjectMapper result = objectMapper.registerModule(module);
        assertNotNull(result);
    }

}