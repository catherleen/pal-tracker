package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    @Autowired
    DataSource datasource;
    @Bean
    public TimeEntryRepository timeEntryRepository(){

        return new JdbcTimeEntryRepository(datasource);

    }


    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}