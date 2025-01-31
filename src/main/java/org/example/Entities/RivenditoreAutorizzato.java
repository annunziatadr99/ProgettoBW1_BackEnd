package org.example.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class RivenditoreAutorizzato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "RivenditoreAutorizzato")
    private List<Biglietto> biglietti;
}
