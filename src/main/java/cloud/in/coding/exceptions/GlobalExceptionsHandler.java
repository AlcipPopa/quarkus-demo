package cloud.in.coding.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionsHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception ex) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage()))
                .build();
    }

    public record ErrorResponse(String code, String message) {}
}

