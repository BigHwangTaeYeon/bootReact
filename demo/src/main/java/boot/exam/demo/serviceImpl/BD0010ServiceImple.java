package boot.exam.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.exam.demo.mapper.BD0010Mapper;
import boot.exam.demo.service.BD0010Service;
import boot.exam.demo.vo.BD0010VO;
import lombok.Setter;

@Service("BD0010Service")
public class BD0010ServiceImple implements BD0010Service{
    
    @Setter(onMethod_ = {@Autowired})
    private BD0010Mapper BD0010Mapper;

    @Override
    public List<BD0010VO> getBoardList(BD0010VO vo) {
        return BD0010Mapper.getBoardList(vo);
    }

}
