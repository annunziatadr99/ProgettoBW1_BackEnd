package org.example.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Nome;

    @Column(nullable = false, unique = true)
    private String NumeroTessera;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataScadenzaTessera;

    @OneToMany(mappedBy = "user")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "user")
    private List<Abbonamento> abbonamenti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNumeroTessera() {
        return NumeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        NumeroTessera = numeroTessera;
    }

    public Date getDataScadenzaTessera() {
        return dataScadenzaTessera;
    }

    public void setDataScadenzaTessera(Date dataScadenzaTessera) {
        this.dataScadenzaTessera = dataScadenzaTessera;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }
}
