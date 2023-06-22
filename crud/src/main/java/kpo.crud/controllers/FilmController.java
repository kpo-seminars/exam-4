package kpo.crud.controllers;

import kpo.crud.models.Film;
import kpo.crud.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService service;

    /**
     * 1. Получение списка всех фильмов.
     */
    @GetMapping
    public ResponseEntity<StringBuilder> getAllFilms() {
        StringBuilder response = new StringBuilder();
        for (Film film: service.getAll()) {
            response.append("id: ").append(film.getId()).append("\n")
                    .append("name: ").append(film.getName()).append("\n")
                    .append("genre: ").append(film.getGenre()).append("\n")
                    .append("duration min: ").append(film.getDuration()).append("\n")
                    .append("rating: ").append(film.getRating()).append("\n")
                    .append("\n");
        }

        if (response.isEmpty()) {
            return ResponseEntity.ok(new StringBuilder("No films yet"));
        } else {
            return ResponseEntity.ok(response);
        }
    }

    /**
     * 2. Получение списка расписания.
     */
    @GetMapping("/showtimes/{date}")
    public ResponseEntity<StringBuilder> getAllShowtimes(@PathVariable Integer date) {
        StringBuilder response = new StringBuilder();
        for (Film film: service.getAll()) {
            response.append("id: ").append(film.getId()).append("\n")
                    .append("name: ").append(film.getName()).append("\n")
                    .append("date: ").append(film.getDate()).append("\n")
                    .append("time: ").append(film.getTime()).append("\n")
                    .append("\n");
        }

        if (response.isEmpty()) {
            return ResponseEntity.ok(new StringBuilder("No films yet"));
        } else {
            return ResponseEntity.ok(response);
        }
    }

    /**
     * 3. Получение списка билетов.
     */
    @GetMapping("/tickets/{date}")
    public ResponseEntity<StringBuilder> getAllTickets(@PathVariable Integer date) {
        StringBuilder response = new StringBuilder();
        for (Film film: service.getAll()) {
            response.append("id: ").append(film.getId()).append("\n")
                    .append("name: ").append(film.getName()).append("\n")
                    .append("number of tickets: ").append(film.getNumberoftickets()).append("\n")
                    .append("\n");
        }

        if (response.isEmpty()) {
            return ResponseEntity.ok(new StringBuilder("No films yet"));
        } else {
            return ResponseEntity.ok(response);
        }
    }

    /**
     * 4. Удаление фильма по id.
     */
    @DeleteMapping("/films/{id}")
    public ResponseEntity<String> deleteWorkoutById(@PathVariable Integer id) {
        return service.delete(id);
    }
}
