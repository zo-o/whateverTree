package tree.tree.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tree.tree.dto.TreeRequestDto;
import tree.tree.dto.TreeResponseDto;
import tree.tree.mapper.TreeMapper;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TreeService {

    private final TreeMapper treeMapper;

    public List<TreeResponseDto> getTreeList(TreeRequestDto treeRequestDto){
        return treeMapper.getTreeList(treeRequestDto);
    }

    public List<TreeResponseDto> getTreeListBySearch(TreeRequestDto treeRequestDto){
        return treeMapper.getTreeListBySearch(treeRequestDto);
    }
}
