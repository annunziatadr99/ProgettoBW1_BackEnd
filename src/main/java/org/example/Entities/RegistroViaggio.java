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
    private Date DataViaggio;

    @Column(nullable = false)
    private int TempoViaggioEffetivo;

    @ManyToOne
    private Veicolo veicolo;

    @ManyToOne
    private Rotta route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataViaggio() {
        return DataViaggio;
    }

    public void setDataViaggio(Date dataViaggio) {
        DataViaggio = dataViaggio;
    }

    public int getTempoViaggioEffetivo() {
        return TempoViaggioEffetivo;
    }

    public void setTempoViaggioEffetivo(int tempoViaggioEffetivo) {
        TempoViaggioEffetivo = tempoViaggioEffetivo;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public Rotta getRoute() {
        return route;
    }

    public void setRoute(Rotta route) {
        this.route = route;
    }
}
