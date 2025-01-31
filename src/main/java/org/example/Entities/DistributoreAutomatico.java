package org.example.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class DistributoreAutomatico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String locazione;

    @Column(nullable = false)
    private boolean attivo;

    @OneToMany(mappedBy = "distributoreAutomatico")
    private List<Biglietto> biglietti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocazione() {
        return locazione;
    }

    public void setLocazione(String locazione) {
        this.locazione = locazione;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }
}