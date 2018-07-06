package no.greenall.marc.record;

public enum RecordStatus {

    INCREASE_IN_ENCODING_LEVEL('a', "Increase in encoding level"),
    CORRECTED_OR_REVISED('c', "Corrected or revised"),
    DELETED('d', "Deleted"),
    NEW('n', "New"),
    INCREASE_IN_ENCODING_LEVEL_FROM_PREPUBLICATION('p', "Increase in encoding level from prepublication"),
    NOT_SPECIFIED(' ', "Not specified");

    public static final int POSITION = 5;
    private char character;
    private String description;

    RecordStatus(char character, String description) {
        this.character = character;
        this.description = description;
    }

    public static String getAllStatusesPattern() {
        return " acdnp";
    }

    public static int getLeaderPosition() {
        return POSITION;
    }

    public char getCharacter() {
        return character;
    }

    public String getDescription() {
        return description;
    }

    public static RecordStatus get(char character) {
        for (RecordStatus recordStatus : RecordStatus.values()) {
            if (recordStatus.character == character) {
                return recordStatus;
            }
        }
        return null;
    }
}
