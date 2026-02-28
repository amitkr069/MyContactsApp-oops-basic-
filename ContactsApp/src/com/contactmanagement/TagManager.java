package com.contactmanagement;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TagManager {

    private Set<Tag> allTags = new HashSet<>();

    public Set<Tag> getAllTags() {
        return allTags;
    }

    public void createTag() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new tag name: ");
        String name = sc.nextLine();

        Tag tag = new Tag(name);

        if (allTags.add(tag)) {
            System.out.println("Tag created successfully!");
        } else {
            System.out.println("Tag already exists.");
        }
    }

    public void viewTags() {

        if (allTags.isEmpty()) {
            System.out.println("No tags created.");
            return;
        }

        System.out.println("Available Tags:");
        for (Tag tag : allTags) {
            System.out.println("- " + tag.getName());
        }
    }
}
