package boot.exam.demo.manageController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import boot.exam.demo.service.BD0010Service;
import boot.exam.demo.vo.BD0010VO;

@Controller
@RequestMapping("/api")
public class BD0010MC {

	@Resource(name="BD0010Service")
	private BD0010Service BD0010Service;

    @PostMapping("/getBD0010")
    public ModelAndView getBoardDetail(BD0010VO vo){
        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("board", "mv");

        List<BD0010VO> BD0010List = BD0010Service.getBoardList(vo);
        mv.addObject("BD0010List",BD0010List);

        return mv;
    }
}
