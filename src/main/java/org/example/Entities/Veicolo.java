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
    private TipoVeicolo type;

    @Column(nullable = false)
    private int capacita;

    @Column(nullable = false)
    private boolean inServizio;

    @OneToMany(mappedBy = "Veicolo")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "Veicolo")
    private List<RegistroViaggio> RegistroViaggiatori;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeicolo getType() {
        return type;
    }

    public void setType(TipoVeicolo type) {
        this.type = type;
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
        return RegistroViaggiatori;
    }

    public void setRegistroViaggiatori(List<RegistroViaggio> registroViaggiatori) {
        RegistroViaggiatori = registroViaggiatori;
    }
}
