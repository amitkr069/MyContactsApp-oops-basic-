package com.searchfilter;

import java.util.ArrayList;
import java.util.List;
import com.contactmanagement.*;
public class SearchByName implements SearchStrategy {

    @Override
    public List<Contact> search(List<Contact> contacts, String keyword) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(c);
            }
        }

        return result;
    }
}
