package org.example.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rotta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String partenza;

    @Column(nullable = false)
    private String arrivo;

    @Column(nullable = false)
    private int tempoViaggioPrevisto;

    @OneToMany(mappedBy = "rotta")
    private List<RegistroViaggio> registroViaggiatori;

    @OneToMany(mappedBy = "rotta")
    private List<Veicolo> veicoli;  // Ensure this property references the correct field in Veicolo

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    public void setArrivo(String arrivo) {
        this.arrivo = arrivo;
    }

    public int getTempoViaggioPrevisto() {
        return tempoViaggioPrevisto;
    }

    public void setTempoViaggioPrevisto(int tempoViaggioPrevisto) {
        this.tempoViaggioPrevisto = tempoViaggioPrevisto;
    }

    public List<RegistroViaggio> getRegistroViaggiatori() {
        return registroViaggiatori;
    }

    public void setRegistroViaggiatori(List<RegistroViaggio> registroViaggiatori) {
        this.registroViaggiatori = registroViaggiatori;
    }

    public List<Veicolo> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<Veicolo> veicoli) {
        this.veicoli = veicoli;
    }
}