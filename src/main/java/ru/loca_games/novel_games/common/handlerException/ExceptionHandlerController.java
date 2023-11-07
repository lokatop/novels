package ru.loca_games.novel_games.common.handlerException;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.loca_games.novel_games.book.exception.BookNotFoundException;
import ru.loca_games.novel_games.common.exception.EntityNotFoundException;
import ru.loca_games.novel_games.user.exception.UserNotFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public void handleException(HttpServletResponse response, Exception e) throws IOException {
        log.warn("Unhandled error. Message: " + e.getMessage());
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.getWriter().println(e.getMessage());
    }

    @ExceptionHandler(value = {EntityNotFoundException.class, UserNotFoundException.class, BookNotFoundException.class})
    public void handleEntityNotFound(HttpServletResponse response, EntityNotFoundException e) throws IOException {
        log.warn(String.format("Someone is looking for a non-existent object for service = %s and id = %s", e.getServiceName(), e.getId()));
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().println(String.format("Entity with id = %s not found", e.getId()));
        response.setStatus(HttpStatus.NOT_FOUND.value());
    }
}
