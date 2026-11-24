
package together;

public class result {

    // 가맹점
    private String merchant;

    // 결제 금액
    private String amount;

    // 카테고리
    private String category;

    // 생성자
    public result(String merchant, String amount, String category) {
        this.merchant = merchant;
        this.amount = amount;
        this.category = category;
    }

    // Getter
    public String getMerchant() {
        return merchant;
    }

    public String getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

//필드.가맹점,금액,카테고리를 저장하는 변수
//private String merchant;
//private String amount;
//private String category;

//생성자. result객체 생성할때 세가지 정보 받아 저장 (카드사,가격,카테고리)이런식으로
//public Result(String merchant, String amount, String category) {
//this.merchant = merchant;
//this.amount = amount;
//this.category = category; }

//스프링 비유
//Result = DTO
//필드 =데이터 은닉
//생성자 = 객체 초기화
//Getter = 데이터 조회