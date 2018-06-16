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

    @Override
    public String toString() {
        return String.format("%d. nazwa: %s, rozmiar: %s", id, nazwa, rozmiar);
    }
}
