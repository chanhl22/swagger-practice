package sample.swaggerpractice.domain.leaderboard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.swaggerpractice.web.leaderboard.dto.LeaderboardResponse;

@Slf4j
@RequiredArgsConstructor
@Service
public class LeaderboardService {

    @Transactional
    public LeaderboardResponse findLeaderboard(String gameId, int roundNo) {
        return null;
    }

}
