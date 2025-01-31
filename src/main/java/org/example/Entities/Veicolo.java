package org.example.Entities;

import org.example.Enumerated.TipoVeicolo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVeicolo tipo;

    @Column(nullable = false)
    private int capacita;

    @Column(nullable = false)
    private boolean inServizio;

    @OneToMany(mappedBy = "veicolo")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "veicolo")
    private List<RegistroViaggio> registroViaggiatori;

    @ManyToOne
    @JoinColumn(name = "rotta_id")
    private Rotta rotta;  // Ensure this property exists and is correctly named

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeicolo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeicolo tipo) {
        this.tipo = tipo;
    }

    public int getCapacita() {
        return capacita;
    }

    public void setCapacita(int capacita) {
        this.capacita = capacita;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    public List<RegistroViaggio> getRegistroViaggiatori() {
        return registroViaggiatori;
    }

    public void setRegistroViaggiatori(List<RegistroViaggio> registroViaggiatori) {
        this.registroViaggiatori = registroViaggiatori;
    }

    public Rotta getRotta() {
        return rotta;
    }

    public void setRotta(Rotta rotta) {
        this.rotta = rotta;
    }
}