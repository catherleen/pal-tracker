package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry entry);
    public TimeEntry find(Long entryId);
    public List<TimeEntry> list();
    public TimeEntry update(Long entryId, TimeEntry entry);
    public void delete(Long entryId);

}
