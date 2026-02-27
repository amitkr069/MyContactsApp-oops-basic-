package com.searchfilter;

import java.util.List;
import com.contactmanagement.*;

public interface SearchStrategy {

    List<Contact> search(List<Contact> contacts, String keyword);
}
