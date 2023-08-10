package br.com.arthur.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2689849789686763534L;

    public ResourceNotFoundException(String ex) {
        super(ex);
    }


}
