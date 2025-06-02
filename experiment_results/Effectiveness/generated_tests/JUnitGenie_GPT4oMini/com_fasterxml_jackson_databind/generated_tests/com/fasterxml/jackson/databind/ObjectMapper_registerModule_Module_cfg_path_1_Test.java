package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.fail;

public class ObjectMapper_registerModule_Module_cfg_path_1_Test {

    private static class TestModule extends Module {
        @Override
        public String getModuleName() {
            return null; // This will trigger the IllegalArgumentException
        }

        @Override
        public Version version() {
            return Version.unknownVersion(); // Version can be any valid version
        }

        @Override
        public void setupModule(SetupContext context) {
            // No setup needed for this test
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
            // Expected exception
        }
    }


}