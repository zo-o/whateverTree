package tree.tree.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tree.tree.dto.TreeRequestDto;
import tree.tree.dto.TreeResponseDto;
import tree.tree.service.TreeService;
import tree.util.ResultDto;

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
    @GetMapping("/")
    public List<TreeResponseDto> getTreeList(TreeRequestDto treeRequestDto) {
        return treeService.getTreeList(treeRequestDto);
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
}
