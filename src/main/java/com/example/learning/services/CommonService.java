package com.example.learning.services;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * This Service Class is created and used to map functions 
 * that are common and frequently used in applications.
 * @author ibent95
 */
@Service
public class CommonService {

    private final CoreService coreSvc;

    public CommonService(CoreService coreSvc) {
        this.coreSvc = coreSvc;
    }

    /**
     * Generate and return uuid
     * @param stringValueOption
     * @return uuid
     */
    public Object generateUuid(Object... parameters) {
        UUID uuid = UUID.randomUUID();
        
        return ((boolean) parameters[0]) ? uuid.toString() : uuid;
    }

    /**
     * Get value of calculated number of age
     * @param birthDate
     * @return age
     */
    public Integer calculateAge(LocalDate birthDate) {
        // Initial variable
        int age;

        // Set birth of date to calendar
        Calendar birth = new GregorianCalendar();
        birth.setTime(
        	Date.from(birthDate.atStartOfDay(ZoneOffset.UTC).toInstant())
        );

        // Set current date to calendar
        Calendar now = new GregorianCalendar();
        now.setTime(new Date());

        /**
         * Set adjustment variable when different of current year
         * and birth of year less than 0
         */
        int adjust = (
        	now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0
        ) ? -1 : 0 ;

        // Set age
        age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;

        return age;
    }

}
