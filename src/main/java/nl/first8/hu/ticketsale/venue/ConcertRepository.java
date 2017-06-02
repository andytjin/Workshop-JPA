package nl.first8.hu.ticketsale.venue;

/**
 * Created by andy on 30-5-2017.
 */
import nl.first8.hu.ticketsale.Artist.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

@Repository
public class ConcertRepository {

    private final EntityManager entityManager;

    @Autowired
    public ConcertRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Concert> findByArtist(String artist) {
        String jpql = "SELECT concert FROM Concert concert WHERE concert.artist.name = :artist";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("artist", artist);
        return query.getResultList();
    }

    public List<Concert> findByGenre(String genre) {
        int genreToInt = Genre.valueOf(genre.toUpperCase()).ordinal();
        String jpql = "SELECT concert FROM Concert concert WHERE concert.artist.genre = "+genreToInt;
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    public List<Concert> findByLocation(String location) {
        String jpql = "SELECT concert FROM Concert concert WHERE concert.location.name = :location";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("location", location);
        return query.getResultList();
    }

    public List<Concert> findByDate(String date) {
        String jpql = "SELECT concert FROM Concert concert WHERE concert.date >= :date";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("date", date);
        return query.getResultList();
    }
}

