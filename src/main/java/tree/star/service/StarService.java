package tree.star.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tree.config.ResultDto;
import tree.star.dto.StarRequestDto;
import tree.star.mapper.StarMapper;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class StarService {

    private final StarMapper starMapper;

    public ResultDto changeStar(StarRequestDto starRequestDto){
        ResultDto resultDto = new ResultDto();
        HashMap<String,Integer> map = new HashMap();

        if(starMapper.getStarCount(starRequestDto) > 0){
            if(starMapper.deleteStar(starRequestDto) > 0){
                map.put("isLike", 0);
                resultDto.setMsg("즐겨찾기가 취소되었습니다.");
            }
        }else{
            if(starMapper.insertStar(starRequestDto) > 0){
                map.put("isLike", 1);
                resultDto.setMsg("즐겨찾기가 추가되었습니다.");
            }
        }
        resultDto.setData(map);
        resultDto.setSuccess(true);

        return resultDto;
    }
}
