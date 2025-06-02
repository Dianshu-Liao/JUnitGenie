package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_13_Test {

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

        @Override
        public Object getTypeId() {
            return "TestModuleTypeId";
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule testModule = new TestModule();

        try {
            objectMapper.registerModule(testModule);
            assertNotNull(objectMapper); // Ensure objectMapper is not null
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown IllegalArgumentException: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithNullName() {
        ObjectMapper objectMapper = new ObjectMapper();
        Module moduleWithNullName = new Module() {
            @Override
            public String getModuleName() {
                return null; // This will trigger the exception
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

            @Override
            public Object getTypeId() {
                return "TestModuleTypeId";
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
                return "ModuleWithNullVersion";
            }

            @Override
            public Version version() {
                return null; // This will trigger the exception
            }

            @Override
            public void setupModule(SetupContext context) {
            }

            @Override
            public Iterable<Module> getDependencies() {
                return null;
            }

            @Override
            public Object getTypeId() {
                return "TestModuleTypeId";
            }
        };

        try {
            objectMapper.registerModule(moduleWithNullVersion);
            fail("Expected IllegalArgumentException for module without defined version");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined version", e.getMessage());
        }
    }


}