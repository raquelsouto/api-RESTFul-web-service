package api.restful.raquelwinkeler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 6501300977380090995L;

    private Date timestamp;
    private String message;
    private String details;

}
