package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoCompiler;
import org.joda.time.tz.ZoneInfoLogger;
import org.junit.Test;
import java.io.File;

public class tz_ZoneInfoCompiler_main_String_____cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testMainWithVerbose() {
        String[] args = {"-verbose", "-src", "inputDir", "-dst", "outputDir", "sourceFile1", "sourceFile2"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMainWithoutVerbose() {
        String[] args = {"-src", "inputDir", "-dst", "outputDir", "sourceFile1", "sourceFile2"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMainWithMissingSource() {
        String[] args = {"-dst", "outputDir"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMainWithMissingDestination() {
        String[] args = {"-src", "inputDir"};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMainWithNoArguments() {
        String[] args = {};
        try {
            ZoneInfoCompiler.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}