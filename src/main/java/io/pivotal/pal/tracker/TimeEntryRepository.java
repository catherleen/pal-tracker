package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry entry);
    public TimeEntry find(long entryId);
    public List<TimeEntry> list();
    public TimeEntry update(long entryId, TimeEntry entry);
    public void delete(long entryId);

}
