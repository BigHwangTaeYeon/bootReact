package boot.exam.demo.viewController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.exam.demo.config.SessionConst;
import boot.exam.demo.service.BD0010Service;
import boot.exam.demo.vo.BD0010VO;
import boot.exam.demo.vo.LG0010VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class BD0010VC {

	@Resource(name="BD0010Service")
    // @Autowired
	private BD0010Service BD0010Service;

    private final MessageSourceAccessor messageSource;

    @RequestMapping("/BD0010")
    public String getList(HttpServletRequest request, Model model, BD0010VO vo, Locale locale) {
        List<BD0010VO> BD0010List = BD0010Service.getBoardList(vo);
        HttpSession session = request.getSession(false);
        LG0010VO loginMember = (LG0010VO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("member", loginMember);

        String[] replaceValues = new String[]{"바인딩변수1번값", "바인딩변수2번값"};

        ArrayList<String> msgs = new ArrayList<>();
        msgs.add(messageSource.getMessage("test"));
        msgs.add(messageSource.getMessage("like.this.comma.ok"));
        msgs.add(messageSource.getMessage("100"));
        msgs.add(messageSource.getMessage("replace.test", replaceValues));

        msgs.add(messageSource.getMessage("test", Locale.ENGLISH));
        msgs.add(messageSource.getMessage("like.this.comma.ok", Locale.ENGLISH));
        msgs.add(messageSource.getMessage("100", Locale.ENGLISH));
        msgs.add(messageSource.getMessage("replace.test", replaceValues,  Locale.ENGLISH));

        msgs.add(messageSource.getMessage("test", locale));
        msgs.add(messageSource.getMessage("like.this.comma.ok", locale));
        msgs.add(messageSource.getMessage("100", locale));
        msgs.add(messageSource.getMessage("replace.test", replaceValues, locale));

        model.addAttribute("msgs",msgs);
        model.addAttribute("BD0010List",BD0010List);

        return "BD0010/BD0010";
    }
    
    @PostMapping("/ip")
	public ResponseEntity<String> ip (HttpServletRequest request){
		// 요청 보낸 클라이언트 ip 반환
		return ResponseEntity.ok(request.getRemoteAddr());
	}

}
