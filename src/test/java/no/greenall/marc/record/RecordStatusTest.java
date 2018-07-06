package no.greenall.marc.record;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RecordStatusTest {

    @Test
    public void itHasIncreaseInEncodingLevel() {
        String description = "Increase in encoding level";
        char character = 'a';
        assertEquals(character, RecordStatus.INCREASE_IN_ENCODING_LEVEL.getCharacter());
        assertEquals(description, RecordStatus.INCREASE_IN_ENCODING_LEVEL.getDescription());
    }

    @Test
    public void itHasCorrectedOrRevised() {
        String description = "Corrected or revised";
        char character = 'c';
        assertEquals(character, RecordStatus.CORRECTED_OR_REVISED.getCharacter());
        assertEquals(description, RecordStatus.CORRECTED_OR_REVISED.getDescription());
    }

    @Test
    public void itHasDeleted() {
        String description = "Deleted";
        char character = 'd';
        assertEquals(character, RecordStatus.DELETED.getCharacter());
        assertEquals(description, RecordStatus.DELETED.getDescription());
    }

    @Test
    public void itHasNew() {
        String description = "New";
        char character = 'n';
        assertEquals(character, RecordStatus.NEW.getCharacter());
        assertEquals(description, RecordStatus.NEW.getDescription());
    }

    @Test
    public void itHasIncreaseInEncodingLevelFromPrepublication() {
        String description = "Increase in encoding level from prepublication";
        char character = 'p';
        assertEquals(character, RecordStatus.INCREASE_IN_ENCODING_LEVEL_FROM_PREPUBLICATION.getCharacter());
        assertEquals(description, RecordStatus.INCREASE_IN_ENCODING_LEVEL_FROM_PREPUBLICATION.getDescription());
    }

    @Test
    public void itHasNotStated() {
        String description = "Not specified";
        char character = ' ';
        assertEquals(character, RecordStatus.NOT_SPECIFIED.getCharacter());
        assertEquals(description, RecordStatus.NOT_SPECIFIED.getDescription());
    }

    @Test
    public void itHasAllRecordStatusesPattern() {
        String allRecordStatuses = " acdnp";
        assertEquals(allRecordStatuses, RecordStatus.getAllStatusesPattern());
    }

    @Test
    public void itHasAllStatusesInAllStatuesPattern() {
        char[] statuses = RecordStatus.getAllStatusesPattern().toCharArray();
        for (char status : statuses) {
            assertNotNull(RecordStatus.get(status));
        }
    }
}
