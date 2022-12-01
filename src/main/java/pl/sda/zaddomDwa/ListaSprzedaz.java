package pl.sda.zaddomDwa;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.zaddomDwa.model.Sprzedaz;

import java.util.List;

public class ListaSprzedaz {
    public static void main() {

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {

                // wypisz sprzedaze
                TypedQuery<Sprzedaz> zapytanie = session.createQuery("FROM Sprzedaz", Sprzedaz.class);
                List<Sprzedaz> lista = zapytanie.getResultList();
                lista.forEach(System.out::println);



        } catch (Exception e) {
            System.err.println("Błąd czytania listy");
        }
    }
}