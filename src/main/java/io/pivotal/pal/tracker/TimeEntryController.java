package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {


    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {


        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
     public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry entry){
        return new ResponseEntity<>(timeEntryRepository.create(entry), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        TimeEntry entry = timeEntryRepository.find(timeEntryId);
        if (entry == null) {
            return new ResponseEntity<>(entry, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
       return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK);
   }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry entry = timeEntryRepository.update(timeEntryId, expected);
        if (entry == null) {
            return new ResponseEntity<>(entry, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<String>("Deleted", HttpStatus.NO_CONTENT);
    }
}
