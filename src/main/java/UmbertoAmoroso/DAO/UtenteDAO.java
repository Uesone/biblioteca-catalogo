package UmbertoAmoroso.DAO;

import UmbertoAmoroso.Entities.Utente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UtenteDAO extends GenericDAO<Utente> {

    public UtenteDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Utente> trovaPerNome(String nome) {
        return entityManager.createQuery("SELECT u FROM Utente u WHERE u.nome = :nome", Utente.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public Utente trovaPerNumeroTessera(String numeroTessera) {
        return entityManager.createQuery("SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera", Utente.class)
                .setParameter("numeroTessera", numeroTessera)
                .getSingleResult();
    }
}
