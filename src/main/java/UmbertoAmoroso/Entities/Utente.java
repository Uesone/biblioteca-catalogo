package UmbertoAmoroso.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String numeroTessera;
    private LocalDate dataNascita;
    private String indirizzo;

    // Costruttore vuoto richiesto da JPA
    public Utente() {}

    // Costruttore con due parametri (nome e numeroTessera)
    public Utente(String nome, String numeroTessera) {
        this.nome = nome;
        this.numeroTessera = numeroTessera;
        // Imposta valori di default per gli altri campi
        this.dataNascita = LocalDate.now(); // Esempio: data di oggi come default
        this.indirizzo = ""; // Indirizzo vuoto come default
    }

    // Costruttore completo con tutti i parametri
    public Utente(Long id, String nome, String numeroTessera, LocalDate dataNascita, String indirizzo) {
        this.id = id;
        this.nome = nome;
        this.numeroTessera = numeroTessera;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
    }

    // Getter e Setter

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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
