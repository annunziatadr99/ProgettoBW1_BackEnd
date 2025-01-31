package org.example;

import org.example.DAO.*;
import org.example.Entities.*;
import org.example.Enumerated.Periodicita;
import org.example.Enumerated.TipoVeicolo;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UtenteDAO utenteDAO = new UtenteDAO();
        BigliettoDAO bigliettoDAO = new BigliettoDAO();
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
        DistributoreAutomaticoDAO distributoreAutomaticoDAO = new DistributoreAutomaticoDAO();
        RivenditoreAutorizzatoDAO rivenditoreAutorizzatoDAO = new RivenditoreAutorizzatoDAO();
        VeicoloDAO veicoloDAO = new VeicoloDAO();
        RottaDAO rottaDAO = new RottaDAO();
        RegistroViaggioDAO registroViaggioDAO = new RegistroViaggioDAO();

        while (true) {
            System.out.println("1. Aggiungi Utente");
            System.out.println("2. Aggiungi Biglietto");
            System.out.println("3. Aggiungi Abbonamento");
            System.out.println("4. Aggiungi Distributore Automatico");
            System.out.println("5. Aggiungi Rivenditore Autorizzato");
            System.out.println("6. Aggiungi Veicolo");
            System.out.println("7. Aggiungi Rotta");
            System.out.println("8. Uscita");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Inserisci il nome utente: ");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci numero Tessera: ");
                    String numeroTessera = scanner.nextLine();
                    Utente utente = new Utente();
                    utente.setNome(nome);
                    utente.setNumeroTessera(numeroTessera);
                    utente.setDataScadenzaTessera(new Date()); // Set expiry date to current date for simplicity
                    utenteDAO.save(utente);
                    break;
                case 2:
                    System.out.println("Inserisci codice Biglietto: ");
                    String codiceBiglietto = scanner.nextLine();
                    Biglietto biglietto = new Biglietto();
                    biglietto.setCodice(codiceBiglietto);
                    biglietto.setDataEmissione(new Date());
                    biglietto.setValidita(false); // Set to false by default
                    bigliettoDAO.save(biglietto);
                    break;
                case 3:
                    System.out.println("Inserisci il codice di abbonamento:");
                    String codiceAbb = scanner.nextLine();
                    System.out.println("Inserisci la periodicità (SETTIMANALE, MENSILE):");
                    String periodicitaStr = scanner.nextLine();
                    try {
                        Periodicita periodicita = Periodicita.valueOf(periodicitaStr);
                        Abbonamento abbonamento = new Abbonamento();
                        abbonamento.setCodice(codiceAbb);
                        abbonamento.setPeriodicita(periodicita);
                        abbonamento.setDataEmissione(new Date());
                        abbonamento.setDataScadenza(new Date()); // Set expiry date to current date for simplicity
                        abbonamentoDAO.save(abbonamento);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Periodicità non valida. Riprova.");
                    }
                    break;
                case 4:
                    System.out.println("Inserisci la posizione del distributore automatico:");
                    String locazione = scanner.nextLine();
                    DistributoreAutomatico distributoreAutomatico = new DistributoreAutomatico();
                    distributoreAutomatico.setLocazione(locazione);
                    distributoreAutomatico.setAttivo(true); // Set to active by default
                    distributoreAutomaticoDAO.save(distributoreAutomatico);
                    break;
                case 5:
                    System.out.println("Inserisci il nome del rivenditore:");
                    String nomeRivenditore = scanner.nextLine();
                    System.out.println("Inserisci la posizione del rivenditore:");
                    String locazioneRivenditore = scanner.nextLine();
                    RivenditoreAutorizzato rivenditoreAutorizzato = new RivenditoreAutorizzato();
                    rivenditoreAutorizzato.setNome(nomeRivenditore);
                    rivenditoreAutorizzato.setLocazione(locazioneRivenditore);
                    rivenditoreAutorizzatoDAO.save(rivenditoreAutorizzato);
                    break;
                case 6:
                    System.out.println("Inserisci il tipo di veicolo (TRAM, BUS):");
                    String tipoVeicolo = scanner.nextLine();
                    System.out.println("Inserisci la capacità del veicolo:");
                    int capacitaVeicolo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Veicolo veicolo = new Veicolo();
                    veicolo.setTipo(TipoVeicolo.valueOf(tipoVeicolo));
                    veicolo.setCapacita(capacitaVeicolo);
                    veicolo.setInServizio(true); // Set to in service by default
                    veicoloDAO.save(veicolo);
                    break;
                case 7:
                    System.out.println("Inserisci la partenza del percorso:");
                    String partenza = scanner.nextLine();
                    System.out.println("Inserisci il capolinea del percorso:");
                    String arrivo = scanner.nextLine();
                    System.out.println("Inserisci il tempo di percorrenza previsto (minuti):");
                    int tempoviaggioprevisto = scanner.nextInt();
                    scanner.nextLine();
                    Rotta rotta = new Rotta();
                    rotta.setPartenza(partenza);
                    rotta.setArrivo(arrivo);
                    rotta.setTempoViaggioPrevisto(tempoviaggioprevisto);
                    rottaDAO.save(rotta);
                    break;
                case 8:
                    System.out.println("Uscita...");
                    System.exit(0);
                default:
                    System.out.println("Scelta non valida. Riprova!");
            }
        }
    }
}