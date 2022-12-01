package pl.sda.zaddomDwa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.zaddomDwa.model.Kategoria;
import pl.sda.zaddomDwa.model.Produkt;

import java.util.Scanner;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-relations
 * @created 27.11.2022
 */
public class Create_InsertProdukt {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Tworzymy studenta
            System.out.println("Podaj nazwę produktu:");
            String nazwa = scanner.nextLine();

            System.out.println("Podaj kategorię produktu:");
            String kategoriaProduktu = scanner.nextLine();
            Kategoria kategoria = Kategoria.valueOf(kategoriaProduktu);


            Produkt produkt = Produkt.builder()
                    .kategoria(kategoria)
                    .nazwa(nazwa)
                    .build();

            // zapisujemy studenta
            session.persist(produkt);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
}