package moreHibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Obroza {
    @Id
    @GeneratedValue
    private Integer id;

    private String nazwa;

    private String rozmiar;

//  dwukierunkowa relacja - nie trzeba zmieniac w bazie!
//  wystarcza zwykla relacja 1-1 jednokieurnkowa w bazie
    @OneToOne(mappedBy = "obroza") //obroza - member w klasie Pies
    private Pies pies;

    @Override
    public String toString() {
        return String.format("%d. nazwa: %s, rozmiar: %s", id, nazwa, rozmiar);
    }
}
