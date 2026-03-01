package com.searchfilter;

import java.util.ArrayList;
import java.util.List;
import com.contactmanagement.*;

public class SearchByTag implements SearchStrategy {

    @Override
    public List<Contact> search(List<Contact> contacts, String keyword) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {

            for (Tag tag : c.getTags()) {

                if (tag.getName().equalsIgnoreCase(keyword)) {
                    result.add(c);
                    break;
                }
            }
        }

        return result;
    }
}
