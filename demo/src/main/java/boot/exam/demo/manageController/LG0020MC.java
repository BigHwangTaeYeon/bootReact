package boot.exam.demo.manageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.exam.demo.config.SessionManager;
import boot.exam.demo.service.LG0010Service;
import boot.exam.demo.vo.LG0010VO;

@Controller
@RequestMapping("LG0020MC")
public class LG0020MC {

	@Resource(name="sessionManager")
	private SessionManager sessionManager;

    @Autowired
    private LG0010Service LG0010Service;

    @PostMapping("login")
    public String loginV2(@Valid @RequestBody LG0010VO form,
        BindingResult bindingResult, HttpServletResponse response, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }
        
        LG0010VO loginMember = LG0010Service.login(form);
        if (ObjectUtils.isEmpty(loginMember)) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공 처리
        // 세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
        sessionManager.createSession(loginMember, response);
        sessionManager.getSession(request);
        return "LG0010/LG0010";
    }

    @PostMapping("/logout")
    public String logoutV2(HttpServletResponse response, HttpServletRequest request) {
        sessionManager.expire(request);
        return "redirect:/";
    }

    @GetMapping("/home")
    public String homeLoginV2(HttpServletRequest request, Model model) {
        LG0010VO member = (LG0010VO) sessionManager.getSession(request);

        if (ObjectUtils.isEmpty(member)) {
            return "home";
        }

        model.addAttribute("member", member);
        return "api/BD0010";
    }
}
