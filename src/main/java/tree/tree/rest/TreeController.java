package tree.tree.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tree.tree.dto.*;
import tree.tree.service.TreeService;
import tree.config.ResultDto;

import java.util.HashMap;
import java.util.List;

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
    public ResultDto getTreeList(TreeRequestDto treeRequestDto) {
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
    public ResultDto getTreeListBySearch(TreeRequestDto treeRequestDto){
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
    public ResultDto insertTree(TreePostRequestDto treePostRequestDto){
        ResultDto resultDto = new ResultDto();
        String treeId = treeService.insertTree(treePostRequestDto);
        HashMap<String,String> map = new HashMap();
        map.put("treeId", treeId);
        resultDto.setData(map);
        resultDto.setSuccess(true);
        return resultDto;
    }
}
