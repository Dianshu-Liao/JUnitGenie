start_time=$(date +%s)
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.examples.Expander#expand -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.ZipArchiveEntry#setExtraFields -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.StreamCompressor#deflate -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.cpio.CpioArchiveEntry#isNetwork -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.CpBands#parseCpSignature -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.pack200.IntList#add -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream#closeEntry -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.utils.ServiceLoaderIterator#hasNext -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.CpBands#parseCpIMethod -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.dump.DumpArchiveSummary#isMetaDataOnly -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.sevenz.SevenZOutputFile#writeSingleCodec -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.utils.SeekableInMemoryByteChannel#resize -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.ZipFile#createBoundedInputStream -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTypeTableAttribute#resolve -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.bytecode.BCIRenumberedAttribute#renumber -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.ZipFile#positionAtCentralDirectory -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.pack200.ClassBands#createNewAttributeBands -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.cpio.CpioArchiveEntry#isSocket -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.ArchiveStreamFactory#getArchiveInputStreamProviders -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute#getNestedClassFileEntries -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream#tryToReadLiteral -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.utils.BoundedArchiveInputStream#read -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.dump.DumpArchiveInputStream#matches -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel#buildFromLastSplitSegment -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm#setByteCodeOperands -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.dump.DumpArchiveEntry#parse -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.Lister#listZipUsingTarFile -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.ZipArchiveEntry#getRawName -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.bytecode.forms.TableSwitchForm#setByteCodeOperands -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration#SevenZMethodConfiguration -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute#writeBody -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.sevenz.SevenZFile#readPackInfo -DnoExecution=true
gtimeout 1200 mvn chatunitest:method -DselectMethod=org.apache.commons.compress.archivers.zip.ZipArchiveEntry#setSize -DnoExecution=true
end_time=$(date +%s)
duration=$((end_time - start_time))
echo "Execution time: $duration seconds"