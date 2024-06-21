package in.nic.NERIELearning.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
	public static String detectMimeType(byte[] data) {
        try (InputStream stream = new ByteArrayInputStream(data)) {
            // Create a parser and a handler
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();

            // Parse the input stream to extract metadata
            parser.parse(stream, handler, metadata, new ParseContext());

            // Retrieve the MIME type from the metadata
            String mimeType = metadata.get("Content-Type");
            return mimeType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
