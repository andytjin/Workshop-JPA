package nl.first8.hu.ticketsale.Artist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import nl.first8.hu.ticketsale.venue.Concert;

/**
 * Created by andy on 30-5-2017.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Serializable {

    @Id
    private String naam;

    @Enumerated(EnumType.STRING)
    private Genre genre;


}
