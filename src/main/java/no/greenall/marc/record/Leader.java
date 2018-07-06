package no.greenall.marc.record;

import no.greenall.marc.record.exception.MalformedLeaderException;

import java.util.Optional;

class Leader {

    private static final int LEADER_LENGTH = 24;
    private static final String LEADER_LENGTH_ERROR_MESSAGE = "Leader length was %s";
    private static final String RECORD_LENGTH_CONTAINS_ILLEGAL_CHARACTER_MESSAGE = "Record length (%s) contains illegal character";
    private static final int RECORD_LENGTH_BEGIN = 0;
    private static final int RECORD_LENGTH_END = 4;
    private static final int RECORD_STATUS_INDEX = 5;
    private static final int RECORD_TYPE_INDEX = 6;
    private static final int BIBLIOGRAPHIC_LEVEL_INDEX = 7;
    private static final String THE_PROVIDED_RECORD_STATUS_IS_NOT_VALID = "The provided record status (%s) is not valid";

    private int recordLength;
    private RecordStatus recordStatus;
    private RecordType recordType;
    private BibliographicLevel bibliographicLevel;

    public void setLeader(String leaderString) throws MalformedLeaderException {
        parseLeader(leaderString);
    }

    public String getLeader() {
        return formatLeader();
    }

    private String formatLeader() {
        return new StringBuilder()
                .append(String.valueOf(getRecordLength()))
                .append(recordStatus.getCharacter())
                .toString();
    }

    private void parseLeader(String leader) throws MalformedLeaderException {
        int length = leader.length();

        if (length != LEADER_LENGTH) {
            throw new MalformedLeaderException(String.format(LEADER_LENGTH_ERROR_MESSAGE, String.valueOf(length)));
        }

        setRecordLength(leader.substring(RECORD_LENGTH_BEGIN, RECORD_LENGTH_END));
        setRecordStatus(leader.charAt(RECORD_STATUS_INDEX));
        setRecordType(leader.charAt(RECORD_TYPE_INDEX));
        setBibliographicLevel(leader.charAt(BIBLIOGRAPHIC_LEVEL_INDEX));
    }

    private void setRecordType(char recordType) throws MalformedLeaderException {
        if (RecordType.get(recordType) != null) {
            this.recordType = RecordType.get(recordType);
        } else {
            throw new MalformedLeaderException(String.format("The provided record type (%c) is invalid", recordType));
        }
    }

    private void setRecordStatus(char recordStatus) throws MalformedLeaderException {
        if(RecordStatus.get(recordStatus) != null) {
            this.recordStatus = RecordStatus.get(recordStatus);
        } else {
            throw new MalformedLeaderException(String.format(THE_PROVIDED_RECORD_STATUS_IS_NOT_VALID, recordStatus));
        }
    }

    private void setBibliographicLevel(char bibliographicLevel) {
//        Optional.ofNullable(bibliographicLevel).orElse(EMPTY);
    }

    private void setRecordLength(String leader) throws MalformedLeaderException {
        String recordLength = leader.trim();
        if (recordLength.length() > 0) {
            try {
                setRecordLength(new Integer(recordLength));
            } catch (NumberFormatException nfe) {
                throw new MalformedLeaderException(String.format(RECORD_LENGTH_CONTAINS_ILLEGAL_CHARACTER_MESSAGE, recordLength));
            }
        }
    }

    public int getRecordLength() {
        return recordLength;
    }

    private void setRecordLength(int recordLength) {
        this.recordLength = recordLength;
    }

    public RecordStatus getRecordStatus() {
        return this.recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public RecordType getRecordType() {
        return this.recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }

    public void setBibliographicLevel(BibliographicLevel bibliographicLevel) {
        this.bibliographicLevel = bibliographicLevel;
    }

    public BibliographicLevel getBibliographicLevel() {
        return this.bibliographicLevel;
    }
}
