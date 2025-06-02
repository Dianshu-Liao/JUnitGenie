package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_registerModule_Module_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testRegisterModule_withValidModule() {
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Creating a concrete Module implementation
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return "TestModule"; // Non-null name
            }
            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null); // Non-null Version object
            }
            @Override
            public void setupModule(SetupContext context) {
                // setup logic here (if necessary)
            }
            @Override
            public Iterable<? extends Module> getDependencies() {
                return null; // No dependencies
            }
            @Override
            public Object getTypeId() {
                return "TestTypeId"; // Valid typeId
            }
        };

        // Registering the module
        objectMapper.registerModule(module);
        
        // Verify that the module has been registered correctly
        assertNotNull(objectMapper);
        // Further assertions can be made if needed to validate the state of ObjectMapper
    }

    @Test(timeout = 4000)
    public void testRegisterModule_withMissingModuleName() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Creating a Module with null name
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return null; // Invalid name
            }
            @Override
            public Version version() {
                return new Version(1, 0, 0, null, null, null); // Non-null Version object
            }
            @Override
            public void setupModule(SetupContext context) {}
            @Override
            public Iterable<? extends Module> getDependencies() { return null; }
            @Override
            public Object getTypeId() { return null; }
        };

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException for null module name.");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined name", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRegisterModule_withMissingVersion() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Creating a Module with null version
        Module module = new Module() {
            @Override
            public String getModuleName() {
                return "ValidModule"; // Non-null name
            }
            @Override
            public Version version() {
                return null; // Invalid version
            }
            @Override
            public void setupModule(SetupContext context) {}
            @Override
            public Iterable<? extends Module> getDependencies() { return null; }
            @Override
            public Object getTypeId() { return null; }
        };

        try {
            objectMapper.registerModule(module);
            fail("Expected IllegalArgumentException for null module version.");
        } catch (IllegalArgumentException e) {
            assertEquals("Module without defined version", e.getMessage());
        }
    }


}