package smtrpz.mineappgateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import smtrpz.mineappgateway.dto.ApiResponse;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResponseEntity<ApiResponse> ResourceNotFoundException() {
        return new ResponseEntity<>(
                new ApiResponse(
                        false,
                        "Cannot save Car"
                ),
                HttpStatus.NOT_FOUND
        );
    }
    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}