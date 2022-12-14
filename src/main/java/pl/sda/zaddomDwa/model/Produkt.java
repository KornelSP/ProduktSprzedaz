package pl.sda.zaddomDwa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nazwa;

    @Enumerated(value = EnumType.STRING)
    private Kategoria kategoria;

//    @Formula("(SELECT (SUM(cena*ilosc)/SUM(ilosc)) FROM sprzedaz)")
//    private Double sredniaWazona;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "produkt")
    private Set<Sprzedaz> sprzedaze;

}
