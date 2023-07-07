package boot.exam.demo.manageController;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import boot.exam.demo.config.SessionManager;
import boot.exam.demo.service.BD0010Service;
import boot.exam.demo.vo.BD0010VO;

@Controller
@RequestMapping("/api")
public class BD0010MC {

	@Resource(name="BD0010Service")
	private BD0010Service BD0010Service;

	@Resource(name="sessionManager")
	private SessionManager sessionManager;

    @PostMapping("/getBD0010")
    public ModelAndView getBoardDetail(BD0010VO vo, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("board", "mv");
        HttpSession session = request.getSession(false);
        session.getId();
        // LG0010VO = (LG0010VO)sessionManager.getSession(request);
        // LG0010VO loginMember = (LG0010VO)sessionManager.getAttribute(SessionConst.LOGIN_MEMBER);

        List<BD0010VO> BD0010List = BD0010Service.getBoardList(vo);
        mv.addObject("BD0010List",BD0010List);

        return mv;
    }
}
