package no.greenall.marc.record;

public enum RecordType {

    LANGUAGE_MATERIAL('a', "Language material"),
    NOTATED_MUSIC('c', "Notated music"),
    MANUSCRIPT_NOTATED_MUSIC('d', "Manuscript notated music"),
    CARTOGRAPHIC_MATERIAL('e', "Cartographic material"),
    MANUSCRIPT_CARTOGRAPHIC_MATERIAL('f', "Manuscript cartographic material"),
    PROJECTED_MEDIUM('g', "Projected medium"),
    NONMUSICAL_SOUND_RECORDING('i', "Nonmusical sound recording"),
    MUSICAL_SOUND_RECORDING('j', "Musical sound recording"),
    TWO_DIMENSIONAL_NONPROJECTABLE_GRAPHIC('k', "Two-dimensional nonprojectable graphic"),
    COMPUTER_FILE('m', "Computer file"),
    KIT('o', "Kit"),
    MIXED_MATERIALS('p', "Mixed materials"),
    THREE_DIMENSIONAL_ARTIFACT_OR_NATURALLY_OCCURRING_OBJECT('r', "Three-dimensional artifact or naturally occurring object"),
    MANUSCRIPT_LANGUAGE_MATERIAL('t', "Manuscript language material"),
    NOT_SPECIFIED(' ', "Not specified");

    private char character;
    private String description;

    RecordType(char character, String description) {
        this.character = character;
        this.description = description;
    }

    static String getAllTypeCodes() {
        return " acdefgijkmoprt";
    }

    public static int getLeaderPosition() {
        return 6;
    }

    char getCharacter() {
        return character;
    }

    String getDescription() {
        return description;
    }

    static RecordType get(char character) {
        for (RecordType recordType : RecordType.values()) {
            if (character == recordType.character) {
                return recordType;
            }
        }
        return null;
    }
}
