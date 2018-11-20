package io.pivotal.pal.tracker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private List<TimeEntry> entries = new ArrayList<TimeEntry>();
    int index = 0;

    public TimeEntry create(TimeEntry entry){
        entry.setTimeEntryId(index+1);
        entries.add(entry);
        index++;
        return entry;
    }

    public TimeEntry find(long entryId) {

        if (entryId > entries.size()) {
            return null;
        }
         return entries.get((int)entryId-1);
    }

    public List<TimeEntry> list() {
        return entries;
    }

    public TimeEntry update(long entryId, TimeEntry entry) {
        if (entryId > index) {
            return null;
        }

        int indexnow = -1;
        for (int i=0; i<entries.size(); i++) {
            if (entries.get(i).getId()==entryId) {
                indexnow = i;
                break;
            }
        }
        entry.setTimeEntryId(entryId);
        entries.set(indexnow, entry);
        return entry;
    }

    public void delete(long entryId) {
        if (entryId > index) {

            return;
        }
        int indexnow = -1;
        for (int i=0; i<entries.size(); i++) {
            if (entries.get(i).getId()==entryId) {
                indexnow = i;
                break;
            }
        }

        entries.remove((int)indexnow);

    }
}
