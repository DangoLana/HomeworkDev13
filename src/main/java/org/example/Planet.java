package org.example;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @Column(nullable = false, unique = true, length = 20)
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Planet ID must consist only of uppercase Latin letters and digits.")
    private String id;


    @Column(nullable = false, length = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketsFrom;

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketsTo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
