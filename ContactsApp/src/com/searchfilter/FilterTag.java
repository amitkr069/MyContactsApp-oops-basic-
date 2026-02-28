package com.searchfilter;

import com.contactmanagement.*;
import java.util.List;
import java.util.ArrayList;
public class FilterTag implements FilterStrategy{
	@Override
    public List<Contact> filter(List<Contact> contacts, String value) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {

            if (value.equalsIgnoreCase("Organization")
                    && c instanceof Organisation) {

                result.add(c);
            }

            else if (value.equalsIgnoreCase("Person")
                    && c instanceof Person) {

                result.add(c);
            }

//            else if (c instanceof Person) {
//
//                Person p = (Person) c;
//
//                if (p.getCategory().equalsIgnoreCase(value)) {
//                    result.add(p);
//                }
//            }
        }

        return result;
    }
}
