package sample.swaggerpractice.web.leaderboard.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Schema(description = "리더보드 정보")
@Getter
public class LeaderboardResponse {

    @Schema(description = "대회 id", example = "2023060003")
    private final String gameId;

    @Schema(description = "라운드 번호", example = "1")
    private final int roundNo;

    @Schema(description = "점수 정보", example = "[1, 2, 3]")
    private final List<Integer> scores;

    @Builder
    private LeaderboardResponse(String gameId, int roundNo, List<Integer> scores) {
        this.gameId = gameId;
        this.roundNo = roundNo;
        this.scores = scores;
    }

    public static LeaderboardResponse of(String gameId, int roundNo, List<Integer> scores) {
        return LeaderboardResponse.builder()
                .gameId(gameId)
                .roundNo(roundNo)
                .scores(scores)
                .build();
    }

}
