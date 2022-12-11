package tree.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDto {
    private boolean success; //성공유무 : true / false
    private String msg; // 메시지
    private Object data; // data

}
