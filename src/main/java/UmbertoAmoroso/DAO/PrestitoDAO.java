package UmbertoAmoroso.DAO;

import UmbertoAmoroso.Entities.Prestito;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PrestitoDAO extends GenericDAO<Prestito> {

    public PrestitoDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Prestito> trovaPrestitiScaduti() {
        return entityManager.createQuery(
                "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL",
                Prestito.class
        ).getResultList();
    }

    public List<Prestito> trovaPrestitiPerNumeroTessera(String numeroTessera) {
        return entityManager.createQuery(
                        "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera",
                        Prestito.class
                ).setParameter("numeroTessera", numeroTessera)
                .getResultList();
    }
}
