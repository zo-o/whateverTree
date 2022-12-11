package tree.review.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tree.review.dto.ReviewResponseDto;
import tree.review.mapper.ReviewMapper;
import tree.tree.dto.TreeDetailRequestDto;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

	 private final ReviewMapper reviewMapper;

	 public List<ReviewResponseDto> getReviewList(TreeDetailRequestDto treeDetailRequestDto){
		 return reviewMapper.getReviewList(treeDetailRequestDto);
	 }

	 public List<String> getReviewImgList(TreeDetailRequestDto treeDetailRequestDto){
		 return reviewMapper.getReviewImgList(treeDetailRequestDto);
	 }


}
