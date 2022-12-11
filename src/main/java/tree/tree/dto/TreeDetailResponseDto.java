package tree.tree.dto;

import lombok.Getter;
import lombok.Setter;
import tree.review.dto.ReviewResponseDto;

import java.util.List;

@Getter
@Setter
public class TreeDetailResponseDto extends TreeResponseDto{
	public List<String> treeImages;
	public boolean treeLike; // 즐겨찾기 여부
	public List<ReviewResponseDto> reviewList;
}
