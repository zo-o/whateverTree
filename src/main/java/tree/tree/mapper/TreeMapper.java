package tree.tree.mapper;

import org.apache.ibatis.annotations.Mapper;
import tree.tree.dto.TreeRequestDto;
import tree.tree.dto.TreeResponseDto;

import java.util.List;

@Mapper
public interface TreeMapper {
    List<TreeResponseDto> getTreeList(TreeRequestDto treeRequestDto);
    List<TreeResponseDto> getTreeListBySearch(TreeRequestDto treeRequestDto);
}
