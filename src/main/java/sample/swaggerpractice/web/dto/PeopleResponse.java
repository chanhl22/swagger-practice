package sample.swaggerpractice.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "응답 정보")
@Data
public class PeopleResponse {

    @Schema(description = "이름", example = "차니님")
    private String name;

    @Schema(description = "나이", example = "21")
    private int age;

}
