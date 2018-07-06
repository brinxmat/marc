package no.greenall.marc.record;

import no.greenall.marc.record.exception.MalformedLeaderException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LeaderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void itExists() {
        new Leader();
    }

    @Test
    public void itCanLoadAString() throws MalformedLeaderException {
        String leaderString = "                        ";
        Leader leader = new Leader();
        leader.setLeader(leaderString);
        assertNotNull(leader.getLeader());
    }

    @Test
    public void itThrowsErrorIfLeaderLengthIsTooShort() throws MalformedLeaderException {

        int length = 23;
        expectedException.expect(MalformedLeaderException.class);
        expectedException.expectMessage(String.format("Leader length was %s", String.valueOf(length)));
        leaderLengthTester(length);
    }

    @Test
    public void itThrowsErrorIfLeaderLengthIsTooLong() throws MalformedLeaderException {

        int length = 25;
        expectedException.expect(MalformedLeaderException.class);
        expectedException.expectMessage(String.format("Leader length was %s", String.valueOf(length)));
        leaderLengthTester(length);
    }

    private void leaderLengthTester(int length) throws MalformedLeaderException {
        String leaderString = StringUtils.leftPad("", length);
        Leader leader = new Leader();
        leader.setLeader(leaderString);
    }

    @Test
    public void itThrowsErrorIfRecordNumberIsBadlyFormatted() throws MalformedLeaderException {
        expectedException.expect(MalformedLeaderException.class);
        expectedException.expectMessage("Record length (a1cd) contains illegal character");
        String leaderString = "a1cd                    ";
        Leader leader = new Leader();
        leader.setLeader(leaderString);
    }

    @Test
    public void itSupportsValidRecordStatuses() throws MalformedLeaderException {
        RecordStatus[] validStatuses = RecordStatus.values();
        for (RecordStatus status : validStatuses) {
            Leader leader = new Leader();
            leader.setLeader(padSingleLeaderElement(RecordStatus.getLeaderPosition(), String.valueOf(status.getCharacter())));
            assertEquals(status, leader.getRecordStatus());
        }
    }

    @Test
    public void itThrowsExceptionOnInvalidRecordStatuses() throws MalformedLeaderException {
        char[] invalidStatuses = {'&', '%', 'z', 'q', 'g', 'h'};
        for (char status : invalidStatuses) {
            expectedException.expect(MalformedLeaderException.class);
            expectedException.expectMessage(String.format("The provided record status (%c) is not valid", status));
            Leader leader = new Leader();
            leader.setLeader(padSingleLeaderElement(RecordStatus.getLeaderPosition(), String.valueOf(status)));
        }
    }

    @Test
    public void itSupportsValidRecordTypeCodes() throws Exception {
        RecordType[] recordTypes = RecordType.values();
        for (RecordType recordType : recordTypes) {
            Leader leader = new Leader();
            leader.setLeader(padSingleLeaderElement(RecordType.getLeaderPosition(), String.valueOf(recordType.getCharacter())));
            assertEquals(recordType, leader.getRecordType());
        }
    }

    @Test
    public void itThrowsExceptionOnInvalidRecordTypes() throws MalformedLeaderException {
        char[] invalidTypes = {'q', '/', 'z', 'x', '?', '!'};
        for (char type : invalidTypes) {
            expectedException.expect(MalformedLeaderException.class);
            expectedException.expectMessage(String.format("The provided record type (%c) is invalid", type));
            Leader leader = new Leader();
            leader.setLeader(padSingleLeaderElement(RecordType.getLeaderPosition(), String.valueOf(type)));
        }
    }

    @Test
    public void itCanGetAndSetRecordStatus() {
        Leader leader = new Leader();
        RecordStatus recordStatus = RecordStatus.DELETED;
        leader.setRecordStatus(recordStatus);
        assertEquals(recordStatus, leader.getRecordStatus());
    }

    @Test
    public void itCanGetAndSetRecordType() {
        Leader leader = new Leader();
        RecordType recordType = RecordType.LANGUAGE_MATERIAL;
        leader.setRecordType(recordType);
        assertEquals(recordType, leader.getRecordType());
    }

    @Test
    public void itCanGetAndSetBibliographicLevel() {
        Leader leader = new Leader();
        BibliographicLevel bibliographicLevel = BibliographicLevel.MONGRAPHIC_COMPONENT_SOURCE;
        leader.setBibliographicLevel(bibliographicLevel);
        assertEquals(bibliographicLevel, leader.getBibliographicLevel());
    }

    private String padSingleLeaderElement(int begin, String element) {
        return StringUtils.leftPad(element, begin + 1, " ") + StringUtils.rightPad("", 24 - (element.length() + begin), " ");
    }
}
