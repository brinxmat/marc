package no.greenall.marc.record;

public enum BibliographicLevel {
    MONGRAPHIC_COMPONENT_SOURCE('a', "Monographic component part"),
    SERIAL_COMPONENT_PART('b', "Serial component part"),
    COLLECTION('c', "Collection"),
    SUBUNIT('d', "Subunit"),
    INTEGRATING_RESOURCE('i', "Integrating resource"),
    MONOGRAPH_ITEM('m', "Monograph/Item"),
    SERIAL('s', "Serial");

    private static final int POSITION = 7;
    public static final String ALL_BIBLIOGRAPHIC_LEVELS_PATTERN = "abcdims";

    private char character;
    private String description;

    BibliographicLevel(char character, String description) {
        this.character = character;
        this.description = description;
    }

    public int getLeaderPosition() {
        return POSITION;
    }

    public char getCharacter() {
        return character;
    }

    public String getDescription() {
        return description;
    }

    public static BibliographicLevel get(char character) {
        for (BibliographicLevel bibliographicLevel : BibliographicLevel.values()) {
            if (bibliographicLevel.getCharacter() == character) {
                return bibliographicLevel;
            }
        }
        return null;
    }
}
