package raquelwinkeler.apirestfulcourse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3960874927182932451L;

    public ResourceNotFoundException(String s) {
        super(s);
    }
}
