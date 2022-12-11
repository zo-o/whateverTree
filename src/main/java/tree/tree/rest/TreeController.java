package tree.tree.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tree.tree.dto.*;
import tree.tree.service.TreeService;
import tree.config.ResultDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trees")
@RequiredArgsConstructor
public class TreeController {

    private final TreeService treeService;

    /**
     * 가까운 트리 목록 조회
     *
     * @return
     */
    @GetMapping
    public ResultDto getTreeList(@RequestParam Map<String, String> params) {
        // jackson 라이브러리의 ObjectMapper 클래스를 이용하여  Snake Case -> Camel Case
        ObjectMapper mapper = new ObjectMapper();
        TreeRequestDto treeRequestDto = mapper.convertValue(params, TreeRequestDto.class);

        ResultDto resultDto = new ResultDto();
        List<TreeResponseDto> treeResponseDto = treeService.getTreeList(treeRequestDto);
        resultDto.setSuccess(true);
        resultDto.setData(treeResponseDto);

        return resultDto;
    }

    /**
     * 검색한 트리 목록 조회
     * @return
     */
    @GetMapping("/search")
    public ResultDto getTreeListBySearch(@RequestParam Map<String, String> params){
        // jackson 라이브러리의 ObjectMapper 클래스를 이용하여  Snake Case -> Camel Case
        ObjectMapper mapper = new ObjectMapper();
        TreeRequestDto treeRequestDto = mapper.convertValue(params, TreeRequestDto.class);

        ResultDto resultDto = new ResultDto();
        List<TreeResponseDto> treeResponseDto = treeService.getTreeListBySearch(treeRequestDto);
        resultDto.setSuccess(true);
        resultDto.setData(treeResponseDto);

        return resultDto;
    }

    /**
     * 트리 상세조회
     * @param treeDetailRequestDto
     * @return
     */
    @GetMapping("/{treeId}")
    public ResultDto getTree(TreeDetailRequestDto treeDetailRequestDto){
        ResultDto resultDto = new ResultDto();
        TreeDetailResponseDto treeDetailResponseDto = treeService.getTree(treeDetailRequestDto);
        resultDto.setSuccess(true);
        resultDto.setData(treeDetailResponseDto);
        return resultDto;
    }

    /**
     * 트리 등록
     * @param treePostRequestDto
     * @return
     */
    @PostMapping
    public ResultDto insertTree(@RequestBody TreePostRequestDto treePostRequestDto){
        ResultDto resultDto = new ResultDto();
        String treeId = treeService.insertTree(treePostRequestDto);
        HashMap<String,String> map = new HashMap();
        map.put("tree_id", treeId);
        resultDto.setData(map);
        resultDto.setSuccess(true);
        return resultDto;
    }
}
