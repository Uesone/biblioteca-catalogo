package UmbertoAmoroso;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
