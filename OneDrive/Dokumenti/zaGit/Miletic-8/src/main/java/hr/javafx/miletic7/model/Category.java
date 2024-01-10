package hr.javafx.miletic7.model;

import java.io.Serializable;

public class Category extends NamedEntity implements Serializable {
    private String name;
    private String description;

    public Category(Long id, String name, String description) {
        super(id, name);
        this.name = name;
        this.description = description;
    }

    public Category() {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}