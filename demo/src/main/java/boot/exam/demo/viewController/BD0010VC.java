package boot.exam.demo.viewController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.exam.demo.service.BD0010Service;
import boot.exam.demo.vo.BD0010VO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BD0010VC {

	@Resource(name="BD0010Service")
    // @Autowired
	private BD0010Service BD0010Service;

    private final MessageSourceAccessor messageSource;

    @RequestMapping("/BD0010")
    public String getList(Model model, BD0010VO vo, Locale locale) {
        List<BD0010VO> BD0010List = BD0010Service.getBoardList(vo);

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

    @GetMapping("/api/hello")
    public String hello() {
        return "야 이거 가져오냐 ? " + "\n";
    }

    @PostMapping("/api/ip")
	public ResponseEntity<String> ip (HttpServletRequest request){
		// 요청 보낸 클라이언트 ip 반환
		return ResponseEntity.ok(request.getRemoteAddr());
	}

}
