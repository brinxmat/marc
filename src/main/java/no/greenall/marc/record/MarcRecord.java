package no.greenall.marc.record;

import no.greenall.marc.record.exception.MalformedLeaderException;

public class MarcRecord implements Record {

    Leader leader;

    public void setLeader(String leader) throws MalformedLeaderException {
        this.leader.setLeader(leader);
    }

    public Leader getLeader() {
        return this.leader;
    }
}
