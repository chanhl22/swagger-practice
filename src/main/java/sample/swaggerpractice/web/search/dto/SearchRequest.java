package sample.swaggerpractice.web.search.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "검색 요청 정보")
@Getter
public class SearchRequest {

    @Schema(description = "대회 id", example = "2023090004")
    private final String gameId;

    @Schema(description = "현재 라운드 수", example = "2")
    private final int roundNo;

    @Schema(description = "선수 id", example = "10002")
    private final String playerId;

    @Builder
    private SearchRequest(String gameId, int roundNo, String playerId) {
        this.gameId = gameId;
        this.roundNo = roundNo;
        this.playerId = playerId;
    }

}
