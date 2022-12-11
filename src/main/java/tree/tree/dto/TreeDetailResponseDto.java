package tree.tree.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import tree.review.dto.ReviewResponseDto;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TreeDetailResponseDto extends TreeResponseDto{
	private List<String> treeImages;
	private boolean treeLike; // 즐겨찾기 여부
	private List<ReviewResponseDto> reviewList;
}
