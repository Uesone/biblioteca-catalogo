package UmbertoAmoroso;

import UmbertoAmoroso.DAO.UtenteDAO;
import UmbertoAmoroso.Entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

        // Salva gli utenti nel database
        try {
            utenteDAO.salva(utente1);
            utenteDAO.salva(utente2);
            utenteDAO.salva(utente3);
            System.out.println("Utenti aggiunti con successo!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nell'aggiungere utenti.");
        } finally {
            // Chiudi EntityManager
            entityManager.close();
            emf.close();
        }

        System.out.println("Hello World!");
    }
}
