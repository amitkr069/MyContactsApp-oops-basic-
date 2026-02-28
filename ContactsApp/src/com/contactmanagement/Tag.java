package com.contactmanagement;

import java.util.Objects;

public class Tag {

    private String name;

    public Tag(String name) {
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    // Needed for Set uniqueness
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Tag)) return false;

        Tag other = (Tag) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
