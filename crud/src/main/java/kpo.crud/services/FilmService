package kpo.crud.services;

import kpo.crud.models.Film;
import kpo.crud.repositories.FilmRepository;
import kpo.crud.requests.FilmRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository repository;

    public List<Film> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<String> add(FilmRequest request) {
        Film film = new Film();

        if (request.getName() == null || request.getName().equals("")) {
            return new ResponseEntity<>("Incorrect name", HttpStatus.BAD_REQUEST);
        } else if (request.getTime() == null || request.getTime() <= 0 || request.getTime() > 2400)  {
            return new ResponseEntity<>("Incorrect time", HttpStatus.BAD_REQUEST);
        } else if (request.getGenre() == null || request.getGenre().equals("")) {
            return new ResponseEntity<>("Incorrect genre", HttpStatus.BAD_REQUEST);
        } else if (request.getRating() == null || request.getRating() <= 0 || request.getRating() > 10) {
            return new ResponseEntity<>("Incorrect rating", HttpStatus.BAD_REQUEST);
        } else if (request.getDuration() == null || request.getDuration() <= 0 || request.getDuration() > 180)  {
            return new ResponseEntity<>("Incorrect duration", HttpStatus.BAD_REQUEST);
        } else if (request.getDate() == null || request.getDate() <= 0 || request.getDate() > 3112)  {
            return new ResponseEntity<>("Incorrect date", HttpStatus.BAD_REQUEST);
        } else if (request.getNumberoftickets() == null || request.getNumberoftickets() <= 0 || request.getNumberoftickets() > 1000)  {
            return new ResponseEntity<>("Incorrect number of tickets", HttpStatus.BAD_REQUEST);
        }

        film.setName(request.getName());
        film.setTime(request.getTime());
        film.setGenre(request.getGenre());
        film.setDuration(request.getDuration());
        film.setRating(request.getRating());
        film.setDate(request.getDate());
        film.setNumberoftickets(request.getNumberoftickets());

        repository.save(film);

        return ResponseEntity.ok("Film has been successfully created");
    }

    public Film get(int id) {
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<StringBuilder> update(Integer id, FilmRequest request) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(new StringBuilder("Id not found"), HttpStatus.BAD_REQUEST);
        }

        StringBuilder response = new StringBuilder();
        Film film;

        try {
            film = repository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new StringBuilder("Id not found"),HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(request.getName(), "") && !Objects.equals(film.getName(), request.getName())) {
            response.append("Name has been changed").append("\n");
            film.setName(request.getName());
        }

        if (!Objects.equals(request.getGenre(), "") && !Objects.equals(film.getGenre(), request.getGenre())) {
            response.append("Genre has been changed").append("\n");
            film.setGenre(request.getGenre());
        }

        if ((request.getTime() > 0 && request.getTime() <= 2400) && !request.getTime().equals(film.getTime())) {
            response.append("Time has been changed").append("\n");
            film.setTime(request.getTime());
        }

        if ((request.getDate() > 0 && request.getDate() <= 3112) && !request.getDate().equals(film.getDate())) {
            response.append("Date has been changed").append("\n");
            film.setDate(request.getDate());
        }

        if ((request.getDuration() > 0 && request.getDuration() <= 180) && !request.getDuration().equals(film.getDuration())) {
            response.append("Duration has been changed").append("\n");
            film.setDuration(request.getDuration());
        }

        if ((request.getRating() > 0 && request.getRating() <= 10) && !request.getRating().equals(film.getRating())) {
            response.append("Rating has been changed").append("\n");
            film.setRating(request.getRating());
        }

        if ((request.getNumberoftickets() > 0 && request.getNumberoftickets() <= 1000) && !request.getNumberoftickets().equals(film.getNumberoftickets())) {
            response.append("Number of tickets has been changed").append("\n");
            film.setRating(request.getNumberoftickets());
        }

        if (response.isEmpty()) {
            return new ResponseEntity<>(new StringBuilder("Empty response was given"), HttpStatus.BAD_REQUEST);
        }

        repository.save(film);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<String> delete(Integer id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>("Id doesn't exist", HttpStatus.BAD_REQUEST);
        }

        repository.deleteById(id);
        return ResponseEntity.ok("Film has been successfully deleted");
    }
}
