package nl.first8.hu.ticketsale.venue;

/**
 * Created by andy on 30-5-2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/concert")
@Transactional
public class ConcertResource {

    private ConcertRepository concertrepos;

    @Autowired
    public ConcertResource(ConcertRepository concertrepos) {
        this.concertrepos = concertrepos;
    }

    @GetMapping(path = "/artist")
    public ResponseEntity<List<Concert>> getByArtist(@RequestParam("artist") final String artist) {
        try {
            List<Concert> concerts = concertrepos.findByArtist(artist);

            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/genre")
    public ResponseEntity<List<Concert>> getByGenre(@RequestParam("genre") final String genre) {
        try {
            List<Concert> concerts = concertrepos.findByGenre(genre);

            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/Date")
    public ResponseEntity<List<Concert>> getByArtistName(@RequestParam("date") final String date) {
        try {
            List<Concert> concerts = concertrepos.findByDate(date);

            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/location")
    public ResponseEntity<List<Concert>> getByLocation(@RequestParam("location") final String location) {
        try {
            List<Concert> concerts = concertrepos.findByLocation(location);

            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
