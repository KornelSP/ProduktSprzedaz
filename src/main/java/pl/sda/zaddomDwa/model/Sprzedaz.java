package pl.sda.zaddomDwa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sprzedaz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double cena;

    private Double ilosc;

    @CreationTimestamp
    private LocalDate czas;


    @ManyToOne
    @ToString.Exclude
    private Produkt produkt;


}
