package sample.swaggerpractice.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.swaggerpractice.web.dto.PeopleRequest;
import sample.swaggerpractice.web.dto.PeopleResponse;

@Controller
public class TestController {

    @Operation(summary = "1년 더하기", description = "나이를 +1 합니다.")
    @Parameters({
            @Parameter(name = "peopleRequest", description = "이름과 나이 정보")
    })
    @ResponseBody
    @GetMapping("/year")
    public PeopleResponse addOneYear(@RequestBody PeopleRequest peopleRequest) {
        PeopleResponse peopleResponse = new PeopleResponse();

        String name = peopleRequest.getName();
        int age = peopleRequest.getAge() + 1;
        peopleResponse.setName(name);
        peopleResponse.setAge(age);

        return peopleResponse;
    }

}
