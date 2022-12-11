package tree.tree.dto;


import lombok.Getter;
import lombok.Setter;
import tree.config.AuthDto;

@Getter
@Setter
public class TreeDetailRequestDto extends AuthDto {
	private String treeId;
}
