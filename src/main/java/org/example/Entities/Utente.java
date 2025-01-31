package org.example.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String numeroTessera;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataScadenzaTessera;

    @OneToMany(mappedBy = "utente")
    private List<Biglietto> biglietti;

    @OneToMany(mappedBy = "utente")
    private List<Abbonamento> abbonamenti; // Ensure this property references the correct field in Abbonamento

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
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