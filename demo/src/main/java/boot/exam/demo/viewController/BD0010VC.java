package boot.exam.demo.viewController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.exam.demo.vo.TS0010VO;

@Controller
public class BD0010VC {
    @RequestMapping("/BD0010")
    public String getTest(Model model) {
        List<TS0010VO> productList = new ArrayList<>();
        // constructor >> seq, name, price, quantity
        productList.add(new TS0010VO(1,"사과",1000,10));
        productList.add(new TS0010VO(2,"배",2000,16));
        productList.add(new TS0010VO(3,"초콜릿",1000,3));
        productList.add(new TS0010VO(4,"치킨",15000,1));
        //add data to view
        model.addAttribute("item",productList);

        return "BD0010/BD0010";
    }
}
