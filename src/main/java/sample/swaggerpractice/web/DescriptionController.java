package sample.swaggerpractice.web;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DescriptionController {

    @Operation(summary = "문서 작성 1", description = "description을 길게 작성하는 경우가 있습니다.<br>br로 줄 바꿀수도 있고\\n\\\\n으로도 줄바꿈이 가능합니다.")
    @ResponseBody
    @GetMapping("/create/doc/1")
    public void createDoc1() {

    }

    @Operation(summary = "문서 작성 2", description = "심지어는 마크다운 문법을 지원합니다." +
            "\n### 결과" +
            "\n- 내용 1" +
            "\n- 내용 2" +
            "\n- 내용 3")
    @ResponseBody
    @GetMapping("/create/doc/2")
    public void createDoc2() {

    }

}
