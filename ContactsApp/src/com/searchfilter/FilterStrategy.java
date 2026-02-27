package com.searchfilter;

import com.contactmanagement.*;
import java.util.List;

public interface FilterStrategy {
	List<Contact> filter(List<Contact> contacts, String value);
	
}
