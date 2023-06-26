package boot.exam.demo.manageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BD0010MC {
    @PostMapping("/getBD0010")
    public ModelAndView getBoardDetail(){
        ModelAndView mv = new ModelAndView("jsonView");
        
        mv.addObject("board", "mv");
        return mv;
    }
}
