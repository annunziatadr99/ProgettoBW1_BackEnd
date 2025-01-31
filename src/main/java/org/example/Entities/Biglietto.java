package org.example.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codice;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissione;

    @Column(nullable = false)
    private boolean validita;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Veicolo veicolo;

    @ManyToOne
    private DistributoreAutomatico distributoreAutomatico;

    @ManyToOne
    private RivenditoreAutorizzato rivenditoreAutorizzato;

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

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public boolean isValidita() {
        return validita;
    }

    public void setValidita(boolean validita) {
        this.validita = validita;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public DistributoreAutomatico getDistributoreAutomatico() {
        return distributoreAutomatico;
    }

    public void setDistributoreAutomatico(DistributoreAutomatico distributoreAutomatico) {
        this.distributoreAutomatico = distributoreAutomatico;
    }

    public RivenditoreAutorizzato getRivenditoreAutorizzato() {
        return rivenditoreAutorizzato;
    }

    public void setRivenditoreAutorizzato(RivenditoreAutorizzato rivenditoreAutorizzato) {
        this.rivenditoreAutorizzato = rivenditoreAutorizzato;
    }
}
