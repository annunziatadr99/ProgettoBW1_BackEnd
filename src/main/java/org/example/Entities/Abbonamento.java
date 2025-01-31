package org.example.Entities;

import org.example.Enumerated.Periodicita;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Abbonamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodicita periodicita;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEmissione;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataScadenza;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente; // Ensure this property exists

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}