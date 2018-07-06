package no.greenall.marc.record;

import org.junit.Test;

import static org.junit.Assert.*;

public class BibliographicLevelTest {

    @Test
    public void getLeaderPosition() {
        assertEquals(7, BibliographicLevel.SUBUNIT.getLeaderPosition());
    }

    @Test
    public void getCharacter() {
        assertEquals('a', BibliographicLevel.MONGRAPHIC_COMPONENT_SOURCE.getCharacter());
    }

    @Test
    public void getDescription() {
        assertEquals("Subunit", BibliographicLevel.SUBUNIT.getDescription());
    }

    @Test
    public void get() {
        assertEquals(BibliographicLevel.INTEGRATING_RESOURCE, BibliographicLevel.get('i'));
    }
}