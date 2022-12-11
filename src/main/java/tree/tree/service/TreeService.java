package tree.tree.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import tree.review.dto.ReviewResponseDto;
import tree.review.service.ReviewService;
import tree.tree.dto.*;
import tree.tree.mapper.TreeMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TreeService {

    private final TreeMapper treeMapper;
    private final ReviewService reviewService;

    public List<TreeResponseDto> getTreeList(TreeRequestDto treeRequestDto){
        return treeMapper.getTreeList(treeRequestDto);
    }

    public List<TreeResponseDto> getTreeListBySearch(TreeRequestDto treeRequestDto){
        return treeMapper.getTreeListBySearch(treeRequestDto);
    }

    public TreeDetailResponseDto getTree(TreeDetailRequestDto treeDetailRequestDto){
        TreeDetailResponseDto treeDetailResponseDto = treeMapper.getTree(treeDetailRequestDto);
        if(!ObjectUtils.isEmpty(treeDetailResponseDto)){
            treeDetailResponseDto.setReviewList(reviewService.getReviewList(treeDetailRequestDto));
            treeDetailResponseDto.setTreeImages(reviewService.getReviewImgList(treeDetailRequestDto));
        }

        return treeDetailResponseDto;
    }

    public String insertTree(TreePostRequestDto treePostRequestDto){
        treeMapper.insertTree(treePostRequestDto);
        return Integer.toString(treePostRequestDto.getTreeId());
    }
}
