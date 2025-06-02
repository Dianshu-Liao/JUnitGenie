package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_4_Test {

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

        @Override
        public Iterable<Module> getDependencies() {
            return null; // No dependencies for this test module
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule testModule = new TestModule();

        // Test successful registration of the module
        ObjectMapper result = objectMapper.registerModule(testModule);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithNullName() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module moduleWithNullName = new Module() {
            @Override
            public String getModuleName() {
                return null; // This will trigger the IllegalArgumentException
            }

            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null);
            }

            @Override
            public void setupModule(SetupContext context) {
            }

            @Override
            public Iterable<Module> getDependencies() {
                return null;
            }
        };

        try {
            objectMapper.registerModule(moduleWithNullName);
            fail("Expected IllegalArgumentException for module without defined name");
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
                return "ValidModule";
            }

            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null); // Changed to a valid version
            }

            @Override
            public void setupModule(SetupContext context) {
            }

            @Override
            public Iterable<Module> getDependencies() {
                return null;
            }
        };

        try {
            objectMapper.registerModule(moduleWithNullVersion);
            fail("Expected IllegalArgumentException for module without defined version");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined version", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithDuplicateRegistration() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule testModule = new TestModule();
        objectMapper.registerModule(testModule); // First registration

        // Registering the same module again should not throw an exception
        ObjectMapper result = objectMapper.registerModule(testModule);
        assertNotNull(result);
    }


}