package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_11_Test {

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

    @Test(expected = IllegalArgumentException.class)
    public void testRegisterModule_NullModuleName() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module moduleWithNullName = new Module() {
            @Override
            public String getModuleName() {
                return null; // Invalid module name
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

        // This should throw an IllegalArgumentException
        objectMapper.registerModule(moduleWithNullName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRegisterModule_NullVersion() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module moduleWithNullVersion = new Module() {
            @Override
            public String getModuleName() {
                return "ValidModule";
            }

            @Override
            public Version version() {
                return null; // Invalid version
            }

            @Override
            public void setupModule(SetupContext context) {
            }

            @Override
            public Iterable<Module> getDependencies() {
                return null;
            }
        };

        // This should throw an IllegalArgumentException
        objectMapper.registerModule(moduleWithNullVersion);
    }

    @Test(timeout = 4000)
    public void testRegisterModule_IgnoreDuplicateRegistrations() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule testModule = new TestModule();

        // Register the module for the first time
        objectMapper.registerModule(testModule);
        // Register the same module again
        ObjectMapper result = objectMapper.registerModule(testModule);
        
        // Ensure that the result is still the same ObjectMapper instance
        assertSame(objectMapper, result);
    }


}