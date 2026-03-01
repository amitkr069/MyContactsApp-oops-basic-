package com.searchfilter;


import java.util.ArrayList;
import java.util.List;
import com.contactmanagement.*;

public class FilterByTag implements FilterStrategy {

    @Override
    public List<Contact> filter(List<Contact> contacts, String value) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {

            for (Tag tag : c.getTags()) {

                if (tag.getName().equalsIgnoreCase(value)) {
                    result.add(c);
                    break;
                }
            }
        }

        return result;
    }
}
