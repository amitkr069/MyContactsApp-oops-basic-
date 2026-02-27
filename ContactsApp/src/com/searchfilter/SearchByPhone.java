package com.searchfilter;

import java.util.ArrayList;
import java.util.List;
import com.contactmanagement.*;
public class SearchByPhone implements SearchStrategy {

    @Override
    public List<Contact> search(List<Contact> contacts, String keyword) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {
            if (c.getPhone().contains(keyword)) {
                result.add(c);
            }
        }

        return result;
    }
}