package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_zip_ZipArchiveInputStream_canReadEntryData_ArchiveEntry_cfg_path_1_Test {

    private class TestArchiveEntry implements ArchiveEntry {
        private final String name;
        private final boolean isDirectory;
        private final long size;

        public TestArchiveEntry(String name, boolean isDirectory, long size) {
            this.name = name;
            this.isDirectory = isDirectory;
            this.size = size;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public java.util.Date getLastModifiedDate() {
            return new java.util.Date();
        }

        @Override
        public boolean isDirectory() {
            return isDirectory;
        }

        @Override
        public long getSize() {
            return size;
        }

        @Override
        public java.nio.file.Path resolveIn(java.nio.file.Path path) {
            return path.resolve(name);
        }
    }

    @Test(timeout = 4000)
    public void testCanReadEntryDataWithNonZipEntry() {
        ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(System.in);
        ArchiveEntry nonZipEntry = new TestArchiveEntry("test.txt", false, 100);

        boolean result = zipInputStream.canReadEntryData(nonZipEntry);
        assertFalse(result);
    }

}