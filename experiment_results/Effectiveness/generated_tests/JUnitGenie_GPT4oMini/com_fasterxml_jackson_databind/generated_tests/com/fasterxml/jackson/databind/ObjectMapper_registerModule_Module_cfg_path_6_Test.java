package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.MapperFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_6_Test {

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
            objectMapper.registerModule(module);
            // Verify that the module was registered successfully
            assertNotNull(objectMapper._registeredModuleTypes);
            assertTrue(objectMapper._registeredModuleTypes.contains(module.getTypeId()));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithNullName() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module module = new TestModule() {
            @Override
            public String getModuleName() {
                return null; // Simulate a module without a name
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
        Module module = new TestModule() {
            @Override
            public Version version() {
                return null; // Simulate a module without a version
            }
        };

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException for module without defined version");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined version", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithDuplicateRegistration() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule module = new TestModule();

        try {
            objectMapper.registerModule(module);
            // Register the same module again
            objectMapper.registerModule(module);
            // Verify that the module was not added again
            assertEquals(1, objectMapper._registeredModuleTypes.size());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}