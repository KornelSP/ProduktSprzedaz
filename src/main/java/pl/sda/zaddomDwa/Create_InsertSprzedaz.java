package pl.sda.zaddomDwa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.zaddomDwa.model.Produkt;
import pl.sda.zaddomDwa.model.Sprzedaz;

import java.util.Scanner;

public class Create_InsertSprzedaz {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // Dodaj sprzedaż
        //  - zapytaj użytkownika o:
        //      - id produktu, któremu chce dodać sprzedaz
        System.out.println("Podaj id produktu:");
        String idProduktu = scanner.nextLine();
        Long id = Long.parseLong(idProduktu);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            //  Następnie znajdź ten produkt i jeśli nie istnieje, zwróć komunikat.
            Produkt szukanyProdukt = session.get(Produkt.class, id);

            //  Jeśli produkt istnieje
            if (szukanyProdukt != null) {
                // to zapytaj o wartość oceny.
                System.out.println("Podaj cenę:");
                String dodawanaCena = scanner.nextLine();
                double wartoscCeny = Double.parseDouble(dodawanaCena);

                System.out.println("Podaj ilość:");
                String dodawanaIlosc = scanner.nextLine();
                double wartoscIlosc = Double.parseDouble(dodawanaIlosc);


                //  Stwórz obiekt oceny i przypisz do oceny studenta.
                Sprzedaz nowaCena = Sprzedaz.builder()
                        .produkt(szukanyProdukt)
                        .cena(wartoscCeny)
                        .ilosc(wartoscIlosc)
                        .build();

                //  Zapisz ocene.
                session.persist(nowaCena);

            } else {
                System.err.println("Taki produkt nie istnieje");
            }

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd dodawania Produktu do bazy");
        }
    }
}