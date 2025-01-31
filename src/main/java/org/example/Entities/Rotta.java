package org.example.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rotta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Partenza;

    @Column(nullable = false)
    private String Arrivo;

    @Column(nullable = false)
    private int Tempoviaggioprevisto;

    @OneToMany(mappedBy = "Rotta")
    private List<Veicolo> veicoli;

    @OneToMany(mappedBy = "Rotta")
    private List<RegistroViaggio> RegistroViaggiatori;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartenza() {
        return Partenza;
    }

    public void setPartenza(String partenza) {
        Partenza = partenza;
    }

    public String getArrivo() {
        return Arrivo;
    }

    public void setArrivo(String arrivo) {
        Arrivo = arrivo;
    }

    public int getTempoviaggioprevisto() {
        return Tempoviaggioprevisto;
    }

    public void setTempoviaggioprevisto(int tempoviaggioprevisto) {
        Tempoviaggioprevisto = tempoviaggioprevisto;
    }

    public List<Veicolo> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<Veicolo> veicoli) {
        this.veicoli = veicoli;
    }

    public List<RegistroViaggio> getRegistroViaggiatori() {
        return RegistroViaggiatori;
    }

    public void setRegistroViaggiatori(List<RegistroViaggio> registroViaggiatori) {
        RegistroViaggiatori = registroViaggiatori;
    }
}
