package sample.swaggerpractice.web.leaderboard;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.swaggerpractice.domain.leaderboard.LeaderboardService;
import sample.swaggerpractice.web.ApiResponse;
import sample.swaggerpractice.web.leaderboard.dto.LeaderboardResponse;

@Tag(name = "리더보드", description = "리더보드/스코어 API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @Operation(summary = "실시간 순위 조회", description = "진행중인 게임의 각 라운드 실시간 순위를 조회합니다.")
    @Parameters({
            @Parameter(name = "gameId", description = "대회 id", example = "2023060003"),
            @Parameter(name = "roundNo", description = "라운드 번호", example = "1")
    })
    @GetMapping("/leaderboard_v1")
    public LeaderboardResponse leaderboard_v1(@RequestParam(name = "gameId") String gameId, @RequestParam(name = "roundNo") int roundNo) {
        log.debug("실시간 순위 조회: gameId = {}, roundNumber = {}", gameId, roundNo);
        return leaderboardService.findLeaderboard(gameId, roundNo);
    }

    @Operation(summary = "실시간 순위 조회", description = "진행중인 게임의 각 라운드 실시간 순위를 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공",
                    content = {@Content(schema = @Schema(implementation = LeaderboardResponse.class))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400", description = "해당 정보가 존재하지 않습니다.",
                    content = {@Content(schemaProperties = {
                            @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "400")),
                            @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "잘못된 요청입니다."))})}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "알 수 없는 에러가 발생했습니다.",
                    content = {@Content(schemaProperties = {
                            @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "500")),
                            @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "알 수 없는 에러가 발생했습니다."))})})
    })
    @Parameters({
            @Parameter(name = "gameId", description = "대회 id", example = "2023060003"),
            @Parameter(name = "roundNo", description = "라운드 번호", example = "1")
    })
    @GetMapping("/leaderboard_v2")
    public LeaderboardResponse leaderboard_v2(@RequestParam(name = "gameId") String gameId, @RequestParam(name = "roundNo") int roundNo) {
        log.debug("실시간 순위 조회: gameId = {}, roundNumber = {}", gameId, roundNo);
        return leaderboardService.findLeaderboard(gameId, roundNo);
    }

    @Operation(summary = "실시간 순위 조회", description = "진행중인 게임의 각 라운드 실시간 순위를 조회합니다.")
    @ApiResponses(value = {
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공",
//                    content = {@Content(schema = @Schema(implementation = LeaderboardResponse.class))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400", description = "해당 정보가 존재하지 않습니다.",
                    content = {@Content(schemaProperties = {
                            @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "400")),
                            @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "잘못된 요청입니다."))})}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "알 수 없는 에러가 발생했습니다.",
                    content = {@Content(schemaProperties = {
                            @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "500")),
                            @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "알 수 없는 에러가 발생했습니다."))})})
    })
    @Parameters({
            @Parameter(name = "gameId", description = "대회 id", example = "2023060003"),
            @Parameter(name = "roundNo", description = "라운드 번호", example = "1")
    })
    @GetMapping("/leaderboard_v3")
    public ApiResponse<LeaderboardResponse> leaderboard_v3(@RequestParam(name = "gameId") String gameId, @RequestParam(name = "roundNo") int roundNo) {
        log.debug("실시간 순위 조회: gameId = {}, roundNumber = {}", gameId, roundNo);
        return ApiResponse.ok(leaderboardService.findLeaderboard(gameId, roundNo));
    }

    @Operation(summary = "실시간 순위 조회", description = "진행중인 게임의 각 라운드 실시간 순위를 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200", description = "성공", useReturnTypeSchema = true),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400", description = "해당 정보가 존재하지 않습니다.",
                    content = {@Content(schemaProperties = {
                            @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "400")),
                            @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "잘못된 요청입니다."))})}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500", description = "알 수 없는 에러가 발생했습니다.",
                    content = {@Content(schemaProperties = {
                            @SchemaProperty(name = "code", schema = @Schema(type = "integer", example = "500")),
                            @SchemaProperty(name = "message", schema = @Schema(type = "string", example = "알 수 없는 에러가 발생했습니다."))})})
    })
    @Parameters({
            @Parameter(name = "gameId", description = "대회 id", example = "2023060003"),
            @Parameter(name = "roundNo", description = "라운드 번호", example = "1")
    })
    @GetMapping("/leaderboard_v4")
    public ApiResponse<LeaderboardResponse> leaderboard_v4(@RequestParam(name = "gameId") String gameId, @RequestParam(name = "roundNo") int roundNo) {
        log.debug("실시간 순위 조회: gameId = {}, roundNumber = {}", gameId, roundNo);
        return ApiResponse.ok(leaderboardService.findLeaderboard(gameId, roundNo));
    }

    @Operation(summary = "실시간 순위 조회", description = "진행중인 게임의 각 라운드 실시간 순위를 조회합니다.")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @Parameters({
            @Parameter(name = "gameId", description = "대회 id", example = "2023060003"),
            @Parameter(name = "roundNo", description = "라운드 번호", example = "1")
    })
    @GetMapping("/leaderboard_v5")
    public ApiResponse<LeaderboardResponse> leaderboard_v5(@RequestParam(name = "gameId") String gameId, @RequestParam(name = "roundNo") int roundNo) {
        log.debug("실시간 순위 조회: gameId = {}, roundNumber = {}", gameId, roundNo);
        return ApiResponse.ok(leaderboardService.findLeaderboard(gameId, roundNo));
    }

}
