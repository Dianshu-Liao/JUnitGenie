package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.FormatFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig_without_FormatFeature_cfg_path_4_Test {

    private class TestFormatFeature implements FormatFeature {
        private final int mask;

        public TestFormatFeature(int mask) {
            this.mask = mask;
        }

        @Override
        public boolean enabledByDefault() {
            return false;
        }

        @Override
        public int getMask() {
            return mask;
        }

        @Override
        public boolean enabledIn(int flags) {
            return (flags & getMask()) != 0;
        }
    }



}
