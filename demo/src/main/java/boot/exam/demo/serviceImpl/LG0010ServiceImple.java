package boot.exam.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.exam.demo.mapper.LG0010Mapper;
import boot.exam.demo.service.LG0010Service;
import boot.exam.demo.vo.LG0010VO;
import lombok.Setter;

@Service("LG0010Service")
public class LG0010ServiceImple implements LG0010Service{
    
    @Setter(onMethod_ = {@Autowired})
    private LG0010Mapper LG0010Mapper;

    @Override
    public LG0010VO login(LG0010VO vo){
        return LG0010Mapper.login(vo);
    }
}
