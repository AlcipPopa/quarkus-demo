package cloud.in.coding.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException ex) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse(Response.Status.NOT_FOUND.getReasonPhrase(), ex.getMessage()))
                .build();
    }

    public record ErrorResponse(String code, String message) {}
}

