package boot.exam.demo.manageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import boot.exam.demo.config.SessionConst;
import boot.exam.demo.config.SessionManager;
import boot.exam.demo.service.LG0010Service;
import boot.exam.demo.vo.LG0010VO;

@Controller
public class LG0010MC {

	@Resource(name="sessionManager")
	private SessionManager sessionManager;

    @Autowired
    private LG0010Service LG0010Service;

    @PostMapping("login")
    public String loginV2(@Valid @RequestBody LG0010VO form,
        BindingResult bindingResult, HttpServletResponse response, HttpServletRequest request) {
        //...기존 코드와 동일
        // form.setLoginId("test");
        // form.setPassword("1234");
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }
        
        // Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        LG0010VO loginMember = LG0010Service.login(form);
        if (ObjectUtils.isEmpty(loginMember)) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공 처리
        // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        // 세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        // return "redirect:/";
        return "LG0010/LG0010";
    }

    @PostMapping("/logout")
    public String logoutV2(HttpServletResponse response, HttpServletRequest request) {
		// 세션을 삭제한다.
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/")
    public String homeLoginV2(HttpServletRequest request, Model model) {
        LG0010VO member = (LG0010VO) sessionManager.getSession(request);

        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }
}
