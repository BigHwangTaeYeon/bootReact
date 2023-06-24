package boot.exam.demo.viewController;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.exam.demo.service.BD0010Service;
import boot.exam.demo.vo.BD0010VO;

@Controller
public class BD0010VC {

	@Resource(name="BD0010Service")
	private BD0010Service BD0010Service;

    @RequestMapping("/BD0010")
    public String getList(Model model, BD0010VO vo) {
        List<BD0010VO> BD0010List = BD0010Service.getBoardList(vo);

        model.addAttribute("BD0010List",BD0010List);

        return "BD0010/BD0010";
    }
}
