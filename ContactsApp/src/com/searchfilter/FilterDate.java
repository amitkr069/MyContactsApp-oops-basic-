package com.searchfilter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.contactmanagement.*;

// for Use case 10
public class FilterDate implements FilterStrategy{
	@Override
    public List<Contact> filter(List<Contact> contacts, String value) {

        List<Contact> result = new ArrayList<>();

        try {
            LocalDate inputDate = LocalDate.parse(value);

            for (Contact c : contacts) {
                if (c.getDateAdded().equals(inputDate)) {
                    result.add(c);
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid date format. Use yyyy-mm-dd");
        }

        return result;
    }
}
