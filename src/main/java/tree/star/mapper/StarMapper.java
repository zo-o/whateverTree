package tree.star.mapper;

import org.apache.ibatis.annotations.Mapper;
import tree.star.dto.StarRequestDto;

@Mapper
public interface StarMapper {
    int insertStar(StarRequestDto starRequestDto);
    int deleteStar(StarRequestDto starRequestDto);
    int getStarCount(StarRequestDto starRequestDto);
}
