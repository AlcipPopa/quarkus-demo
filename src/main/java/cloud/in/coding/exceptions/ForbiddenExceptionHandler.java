package cloud.in.coding.exceptions;

import io.quarkus.security.ForbiddenException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ForbiddenExceptionHandler implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException ex) {
        return Response.status(Response.Status.FORBIDDEN)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse(
                        Response.Status.FORBIDDEN.getStatusCode(),
                        Response.Status.FORBIDDEN.getReasonPhrase(),
                        "Access denied: missing required role"
                ))
                .build();
    }

    public record ErrorResponse(int status, String code, String message) {}
}

