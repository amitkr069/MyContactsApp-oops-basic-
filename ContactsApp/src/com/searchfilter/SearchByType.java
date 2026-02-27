package com.searchfilter;

import java.util.ArrayList;
import java.util.List;
import com.contactmanagement.*;
public class SearchByType implements SearchStrategy {

    @Override
    public List<Contact> search(List<Contact> contacts, String keyword) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {

            // Organization search
            if (keyword.equalsIgnoreCase("Organisation")
                    && c instanceof Organisation) {

                result.add(c);
            }

            // Person search (all persons)
            else if (keyword.equalsIgnoreCase("Person")
                    && c instanceof Person) {

                result.add(c);
            }

            // Work/Home search
            else if (c instanceof Person) {

                Person p = (Person) c;

                if (p.getCategory().equalsIgnoreCase(keyword)) {
                    result.add(p);
                }
            }
        }

        return result;
    }
}
