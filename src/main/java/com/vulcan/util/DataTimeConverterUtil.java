package com.vulcan.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DataTimeConverterUtil {
    /**
     *
     * @param input
     * @return
     */
    public LocalDateTime stringToLocalDataTime(String input){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(input,dateTimeFormatter);
        return localDateTime;
    }
}
