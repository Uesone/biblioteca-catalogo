package UmbertoAmoroso;

import UmbertoAmoroso.DAO.PrestitoDAO;
import UmbertoAmoroso.DAO.UtenteDAO;
import UmbertoAmoroso.Entities.Prestito;
import UmbertoAmoroso.Entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");

    public static void main(String[] args) {
        // Crea un EntityManager
        EntityManager entityManager = emf.createEntityManager();

        // Crea un'istanza di UtenteDAO
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);

        // Aggiungi alcuni utenti
        Utente utente1 = new Utente("Aldo_Baglio", "T001");
        Utente utente2 = new Utente("Giovanni_Storti", "T002");
        Utente utente3 = new Utente("Giacomo_Poretti", "T003");

        // Crea un'istanza di PrestitoDAO
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);

        // Salva gli utenti nel database
        try {
            utenteDAO.salva(utente1);
            utenteDAO.salva(utente2);
            utenteDAO.salva(utente3);
            System.out.println("Utenti aggiunti con successo!");

            // Aggiungi alcuni prestiti
            Prestito prestito1 = new Prestito(utente1, LocalDate.now().minusDays(10), LocalDate.now().plusDays(5));
            Prestito prestito2 = new Prestito(utente2, LocalDate.now().minusDays(20), LocalDate.now().minusDays(5));
            Prestito prestito3 = new Prestito(utente3, LocalDate.now().minusDays(30), LocalDate.now().plusDays(10));

            prestitoDAO.salva(prestito1);
            prestitoDAO.salva(prestito2);
            prestitoDAO.salva(prestito3);
            System.out.println("Prestiti aggiunti con successo!");

            // Trova e stampa i prestiti scaduti
            List<Prestito> prestitiScaduti = prestitoDAO.trovaPrestitiScaduti();
            System.out.println("Prestiti scaduti: ");
            for (Prestito p : prestitiScaduti) {
                System.out.println("Prestito ID: " + p.getId() + ", Utente: " + p.getUtente().getNome());
            }

            // Trova e stampa i prestiti per numero di tessera
            List<Prestito> prestitiUtente1 = prestitoDAO.trovaPrestitiPerNumeroTessera("T001");
            System.out.println("Prestiti per numero tessera T001: ");
            for (Prestito p : prestitiUtente1) {
                System.out.println("Prestito ID: " + p.getId() + ", Data Prestito: " + p.getDataPrestito());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nell'aggiungere utenti o prestiti.");
        } finally {
            // Chiudi EntityManager
            entityManager.close();
            emf.close();
        }

        System.out.println("Hello World!");
    }
}
