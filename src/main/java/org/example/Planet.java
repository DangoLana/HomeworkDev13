package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @Column(nullable = false, unique = true, length = 20)
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!id.matches("[A-Z0-9]+")) {
            throw new IllegalArgumentException("Planet ID must consist only of uppercase Latin letters and digits.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{id='" + id + "', name='" + name + "'}";
    }
}
