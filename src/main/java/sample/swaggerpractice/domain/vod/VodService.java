package sample.swaggerpractice.domain.vod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.swaggerpractice.web.vod.dto.AddVodRequest;

@Slf4j
@RequiredArgsConstructor
@Service
public class VodService {

    @Transactional
    public void saveVod(AddVodRequest request) {

    }

}
