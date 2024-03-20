package sample.swaggerpractice.web.vod.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sample.swaggerpractice.domain.vod.VodService;
import sample.swaggerpractice.web.ApiResponse;
import sample.swaggerpractice.web.vod.dto.AddVodRequest;

@Tag(name = "VOD", description = "VOD API")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/vod")
public class VodController {

    private final VodService vodService;

    @Operation(summary = "VOD 정보 등록", description = "VOD 정보를 등록합니다.<br>" +
            "RequestBody로 요청을 받으며, Header에는 api-key 정보를 넘겨야 합니다.")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "201", description = "성공", useReturnTypeSchema = true)
    @Parameter(in = ParameterIn.HEADER, name = "api-key", schema = @Schema(type = "string", example = "z2-cFJ+24^b=#YQQ#3@R&^9KY3!kA8Lt"))
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public ApiResponse<Object> saveVod(@RequestBody AddVodRequest request) {
        vodService.saveVod(request);
        return ApiResponse.created();
    }

}
