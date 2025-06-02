package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.file.attribute.FileTimes;

class ZipArchiveEntry_setExtraFields_69_0_Test {

    private static class TestZipExtraField implements ZipExtraField {

        private final ZipShort headerId;

        public TestZipExtraField(ZipShort headerId) {
            this.headerId = headerId;
        }

        @Override
        public ZipShort getHeaderId() {
            return headerId;
        }

        @Override
        public byte[] getLocalFileDataData() {
            return new byte[0];
        }

        @Override
        public ZipShort getLocalFileDataLength() {
            return new ZipShort(0);
        }

        @Override
        public void parseFromLocalFileData(byte[] buffer, int offset, int length) {
            // No parsing logic needed for this test
        }

        @Override
        public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) {
            // No parsing logic needed for this test
        }

        @Override
        public ZipShort getCentralDirectoryLength() {
            // Return a default value for the test
            return new ZipShort(0);
        }

        @Override
        public byte[] getCentralDirectoryData() {
            // Return an empty byte array for the test
            return new byte[0];
        }
    }

    @Test
    void testSetExtraFieldsWithValidFields() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry.zip");
        TestZipExtraField field1 = new TestZipExtraField(new ZipShort((short) 1));
        TestZipExtraField field2 = new TestZipExtraField(new ZipShort((short) 2));
        ZipExtraField[] fields = new ZipExtraField[] { field1, field2 };
        entry.setExtraFields(fields);
        ZipExtraField[] extraFields = entry.getExtraFields();
        assertArrayEquals(fields, extraFields);
    }

    @Test
    void testSetExtraFieldsWithNull() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry.zip");
        entry.setExtraFields(null);
        ZipExtraField[] extraFields = entry.getExtraFields();
        assertArrayEquals(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY, extraFields);
    }

    @Test
    void testSetExtraFieldsWithUnparseableField() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry.zip");
        TestZipExtraField unparseableField = new TestZipExtraField(new ZipShort((short) 3));
        ZipExtraField[] fields = new ZipExtraField[] { unparseableField };
        entry.setExtraFields(fields);
        ZipExtraField[] extraFields = entry.getExtraFields();
        assertArrayEquals(new ZipExtraField[] {}, extraFields);
        assertNull(entry.getUnparseableExtraFieldData());
    }
}
