package sample.swaggerpractice.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "요청 정보")
@Data
public class PeopleRequest {

    @Schema(description = "이름", example = "차니님")
    private String name;

    @Schema(description = "나이", example = "20")
    private int age;

}
