package com.contactmanagement;

import java.util.Scanner;

public class RemoveTag {
	public void remove(ContactManager manager, TagManager tagManager) {

        if (manager.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        if (tagManager.getAllTags().isEmpty()) {
            System.out.println("No tags available. Create tags first.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        // Show contacts
        new ViewContact().viewContact(manager);

        System.out.print("Enter contact number to remove tags: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= manager.getContacts().size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        tagManager.viewTags();

        System.out.print("Enter tag name to remove: ");
        String tagName = sc.nextLine();

        Tag tag = new Tag(tagName);

        if (!tagManager.getAllTags().contains(tag)) {
            System.out.println("Tag does not exist.");
            return;
        }

        manager.getContacts().get(index).removeTag(tag);

        System.out.println("Tag removed successfully!");
    }
}
