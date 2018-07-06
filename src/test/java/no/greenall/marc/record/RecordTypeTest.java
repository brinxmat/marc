package no.greenall.marc.record;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RecordTypeTest {
    @Test
    public void itHasAllTheTypes() {
        assertNotNull(RecordType.LANGUAGE_MATERIAL);
        assertNotNull(RecordType.NOTATED_MUSIC);
        assertNotNull(RecordType.MANUSCRIPT_NOTATED_MUSIC);
        assertNotNull(RecordType.CARTOGRAPHIC_MATERIAL);
        assertNotNull(RecordType.MANUSCRIPT_CARTOGRAPHIC_MATERIAL);
        assertNotNull(RecordType.PROJECTED_MEDIUM);
        assertNotNull(RecordType.NONMUSICAL_SOUND_RECORDING);
        assertNotNull(RecordType.MUSICAL_SOUND_RECORDING);
        assertNotNull(RecordType.TWO_DIMENSIONAL_NONPROJECTABLE_GRAPHIC);
        assertNotNull(RecordType.COMPUTER_FILE);
        assertNotNull(RecordType.KIT);
        assertNotNull(RecordType.MIXED_MATERIALS);
        assertNotNull(RecordType.THREE_DIMENSIONAL_ARTIFACT_OR_NATURALLY_OCCURRING_OBJECT);
        assertNotNull(RecordType.MANUSCRIPT_LANGUAGE_MATERIAL);
        assertNotNull(RecordType.NOT_SPECIFIED);
    }

    @Test
    public void everyTypeIsRepresentedInAllTypesPattern() {
        for (char character : RecordType.getAllTypeCodes().toCharArray()) {
            assertNotNull(RecordType.get(character));
        }
    }
}
