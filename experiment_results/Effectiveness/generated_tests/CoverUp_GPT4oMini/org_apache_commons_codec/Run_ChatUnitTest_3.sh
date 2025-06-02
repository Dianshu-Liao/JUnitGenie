start_time=$(date +%s)
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.cli.Digest#run -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.language.bm.Rule#getInstanceMap -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.language.DoubleMetaphone#conditionCH1 -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.URLCodec#encodeUrl -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.binary.Hex#toDigit -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.binary.Base32#encode -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.binary.Base64#toUrlSafeEncodeTable -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.language.DoubleMetaphone#handleX -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.binary.BinaryCodec#toAsciiChars -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.language.DoubleMetaphone#handleH -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.QuotedPrintableCodec#encode -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.binary.Base64#validateCharacter -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.PercentCodec#encode -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.language.DoubleMetaphone#encode -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.URLCodec#decode -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.PercentCodec#insertAlwaysEncodeChar -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.RFC1522Codec#decodeText -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.language.DaitchMokotoffSoundex#encode -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.binary.Hex#decode -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.BCodec#isStrictDecoding -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.digest.B64#b64from24bit -DnoExecution=true
mvn chatunitest:method -DselectMethod=org.apache.commons.codec.net.BCodec#doEncoding -DnoExecution=true
end_time=$(date +%s)
duration=$((end_time - start_time))
echo "Execution time: $duration seconds"