package boot.exam.demo.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TS0010VO {
    public TS0010VO(int i, String string, int j, int k) {
		this.seq = i;
		this.name = string;
		this.price = j;
		this.quantity = k;
	}
    private int seq;
	private String name;
	private int price;
	private int quantity;
}
