package sample.swaggerpractice.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Schema(description = "응답 공통 규격")
@Getter
public class ApiResponse<T> {

    @Schema(description = "상태 코드", allowableValues = {"200", "400", "500"})
    private final int code;

    @Schema(description = "응답 메시지", example = "OK")
    private final String message;

    @Schema(description = "응답 정보")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    public ApiResponse(HttpStatus status, String message, T data) {
        this.code = status.value();
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, String message, T data) {
        return new ApiResponse<>(httpStatus, message, data);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return of(OK, OK.name(), data);
    }

    public static <T> ApiResponse<T> ok() {
        return of(OK, OK.name(), null);
    }

    public static <T> ApiResponse<T> created() {
        return of(CREATED, CREATED.name(), null);
    }

}
