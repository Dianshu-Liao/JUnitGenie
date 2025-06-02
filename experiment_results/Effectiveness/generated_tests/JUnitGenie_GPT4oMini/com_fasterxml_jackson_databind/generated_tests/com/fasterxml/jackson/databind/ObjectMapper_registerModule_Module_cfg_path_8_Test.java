package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.MapperFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_8_Test {

    private static class TestModule extends Module {
        private final String moduleName;
        private final Version version;

        public TestModule(String name, Version version) {
            if (name == null) {
                throw new IllegalArgumentException("Module without defined name");
            }
            if (version == null) {
                throw new IllegalArgumentException("Module without defined version");
            }
            this.moduleName = name;
            this.version = version;
        }

        @Override
        public String getModuleName() {
            return moduleName; // This should not be null for the test to pass.
        }

        @Override
        public Version version() {
            return version; // This should return a valid version, cannot be null.
        }

        @Override
        public void setupModule(SetupContext context) {
            // Setup logic for the module can be included here if needed.
        }

        @Override
        public Iterable<Module> getDependencies() {
            return null; // For this test, we won't have any dependencies.
        }

        @Override
        public Object getTypeId() {
            return new Object(); // Providing a valid typeId.
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleSuccess() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule module = new TestModule("TestModule", new Version(1, 0, 0, null, null, null));

        ObjectMapper result = objectMapper.registerModule(module);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithoutModuleName() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TestModule module = new TestModule(null, new Version(1, 0, 0, null, null, null));
            objectMapper.registerModule(module);
            fail("Should have thrown IllegalArgumentException for null module name");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("Module without defined name", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithoutVersion() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TestModule module = new TestModule("TestModule", null);
            objectMapper.registerModule(module);
            fail("Should have thrown IllegalArgumentException for null version");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("Module without defined version", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterDuplicateModule() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule module = new TestModule("TestModule", new Version(1, 0, 0, null, null, null));
        objectMapper.registerModule(module); // First registration should succeed.

        // Now attempting to register the same module again
        ObjectMapper result = objectMapper.registerModule(module);
        assertSame(objectMapper, result); // Should return the same instance if duplicate registrations are ignored.
    }

    @Test(timeout = 4000)
    public void testRegisterModuleWithDisabledFeature() {
        ObjectMapper objectMapper = new ObjectMapper();
        TestModule module = new TestModule("TestModule", new Version(1, 0, 0, null, null, null));

        // First disable the feature in ObjectMapper
        objectMapper.disable(MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS);

        ObjectMapper result = objectMapper.registerModule(module);
        assertNotNull(result); // Should still register even if the feature is disabled.
    }


}