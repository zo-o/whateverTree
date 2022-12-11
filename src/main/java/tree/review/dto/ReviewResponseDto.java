package tree.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponseDto {
    public String reviewId;
    public String title;
    public String contents;
    public String reviewImg;
    public String regId;
    public String regDate;
    public String modId;
    public String modDate;
}
