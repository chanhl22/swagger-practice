package sample.swaggerpractice.domain.search;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.swaggerpractice.web.search.dto.SearchRequest;
import sample.swaggerpractice.web.search.dto.SearchResponse;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchService {

    @Transactional
    public SearchResponse search(SearchRequest request) {
        return SearchResponse.isEmpty();
    }

}
