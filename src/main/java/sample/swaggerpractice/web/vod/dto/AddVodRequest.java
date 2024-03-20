package sample.swaggerpractice.web.vod.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "VOD 등록 요청 정보")
@Getter
@NoArgsConstructor
public class AddVodRequest {

    @Schema(description = "AI Highlight 시스템의 VOD 관리 번호", example = "S_2024-001")
    private String vodId;

    @Schema(description = "선수 id", example = "8589")
    private String playerId;

    @Schema(description = "대회 id", example = "2023100004")
    private String gameId;

    @Schema(description = "라운드 번호", example = "2")
    private int roundNo;

    @Builder
    private AddVodRequest(String vodId, String playerId, String gameId, int roundNo) {
        this.vodId = vodId;
        this.playerId = playerId;
        this.gameId = gameId;
        this.roundNo = roundNo;
    }

}
