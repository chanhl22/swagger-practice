package sample.swaggerpractice.web.search.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "검색 응답 정보")
@Getter
public class SearchResponse {

    @Builder
    private SearchResponse() {
    }

    public static SearchResponse isEmpty() {
        return SearchResponse.builder()
                .build();
    }

}
