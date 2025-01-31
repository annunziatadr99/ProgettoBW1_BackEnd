package org.example.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegistroViaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataViaggio;

    @Column(nullable = false)
    private int tempoViaggioEffetivo;

    @ManyToOne
    @JoinColumn(name = "rotta_id")
    private Rotta rotta;

    @ManyToOne
    @JoinColumn(name = "veicolo_id")
    private Veicolo veicolo;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataViaggio() {
        return dataViaggio;
    }

    public void setDataViaggio(Date dataViaggio) {
        this.dataViaggio = dataViaggio;
    }

    public int getTempoViaggioEffetivo() {
        return tempoViaggioEffetivo;
    }

    public void setTempoViaggioEffetivo(int tempoViaggioEffetivo) {
        this.tempoViaggioEffetivo = tempoViaggioEffetivo;
    }

    public Rotta getRotta() {
        return rotta;
    }

    public void setRotta(Rotta rotta) {
        this.rotta = rotta;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }
}