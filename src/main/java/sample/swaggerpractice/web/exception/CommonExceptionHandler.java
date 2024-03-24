package sample.swaggerpractice.web.exception;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import sample.swaggerpractice.web.ApiResponse;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "400", description = "잘못된 요청입니다.",
            content = {@Content(schemaProperties = {
                    @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "400")),
                    @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "잘못된 요청입니다."))})})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResponse<Object> errorResponse(MethodArgumentTypeMismatchException exception) {
        log.info("ERROR: {}", exception.getMessage());
        return ApiResponse.fail(HttpStatus.BAD_REQUEST);
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "500", description = "알 수 없는 에러가 발생했습니다.",
            content = {@Content(schemaProperties = {
                    @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "500")),
                    @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "알 수 없는 에러가 발생했습니다."))})})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> errorResponse(Exception exception) {
        log.info("ERROR: {}", exception.getMessage());
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "404", description = "잘못된 요청입니다.",
            content = {@Content(schemaProperties = {
                    @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "404")),
                    @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "잘못된 요청입니다."))})})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    protected ApiResponse<Object> handleNoHandlerFoundException(NoHandlerFoundException exception,
                                                                HttpServletRequest request) {
        return ApiResponse.fail(HttpStatus.NOT_FOUND);
    }

}
