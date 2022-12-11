package tree.tree.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreePostRequestDto {
    private int treeId;
    private String treeName;
    private String treeAddr;
    private String treeDetailAddr;
    private String treeX;
    private String treeY;
}
