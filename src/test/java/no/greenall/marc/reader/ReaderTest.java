package no.greenall.marc.reader;

import no.greenall.marc.record.MarcRecord;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public class ReaderTest {
    @Test
    public void testItExists() {
        new Reader();
    }

    @Test
    public void testItReadsMarc() throws FileNotFoundException {
        try (InputStream marc = new FileInputStream(new File("src/test/java/resources/files/marc0.mrc"))) {
            MarcRecord marcObject = Reader.read(marc);
            assertNotNull(marcObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
