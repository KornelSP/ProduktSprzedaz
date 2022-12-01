package pl.sda.zaddomDwa;


import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.zaddomDwa.model.Produkt;

import java.util.List;

public class ListaProdukt {
    public static void main() {

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {

                // wypisz produkty
                TypedQuery<Produkt> zapytanie = session.createQuery("FROM Produkt", Produkt.class);
                List<Produkt> lista = zapytanie.getResultList();
                lista.forEach(System.out::println);



        } catch (Exception e) {
            System.err.println("Błąd czytania listy");
        }
    }
}