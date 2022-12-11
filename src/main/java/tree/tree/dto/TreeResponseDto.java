package tree.tree.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TreeResponseDto {
    private String treeId;
    private String treeName;
    private String treeAddr;
    private String treeDetailAddr;
    private String treeX;
    private String treeY;

}
