package sample.swaggerpractice.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "의미없는 요청 정보")
@Data
public class OkRequest {

    @Schema(description = "의미없는 문자열", example = "히히")
    private String string;

}
