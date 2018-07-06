package no.greenall.marc.record;

import java.util.Arrays;

public enum BaseCharacters {

    SPACE (' ', "Space"),
    PIPE ('|', "Pipe"),
    HASH ('#', "Hash");

    private char character;
    private String description;

    BaseCharacters(char character, String description) {
        this.character = character;
        this.description = description;
    }

    public static final char[] ALL_LEADER_NULLS = {SPACE.character, PIPE.character, HASH.character};
    public static final String LEADER_NULLS = Arrays.toString(ALL_LEADER_NULLS);

}
