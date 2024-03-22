package sample.swaggerpractice.web.search;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import sample.swaggerpractice.domain.search.SearchService;
import sample.swaggerpractice.web.ApiResponse;
import sample.swaggerpractice.web.search.dto.SearchRequest;
import sample.swaggerpractice.web.search.dto.SearchResponse;

@Tag(name = "검색", description = "검색 API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SearchService searchService;

    @Operation(summary = "검색 (선수 상세 정보 조회)", description = "검색된 정보들을 응답합니다.<br>" +
            "ModelAttribute 로 요청을 받으며 JSON 을 응답합니다.")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @GetMapping("/search")
    public ApiResponse<SearchResponse> search(@ParameterObject @ModelAttribute SearchRequest request) {
        return ApiResponse.ok(searchService.search(request));
    }

}
