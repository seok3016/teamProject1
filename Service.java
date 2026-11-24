
package together;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    // 금액을 추출하기 위한 정규식
    private static final Pattern MONEY_PATTERN =
            Pattern.compile("([0-9,]+)원");

    // 가맹점별 카테고리
    private static final Map<String, String> categories = Map.of(
            "홍콩반점", "식비",
            "스타벅스", "카페",
            "이디야", "카페",
            "대구 지하철", "교통",
            "버스", "교통",
            "무신사", "쇼핑",
            "롯데리아", "식비"
    );

    // 카드 알림 분석 메서드
    public result analyze(String message) {

        // 1. 금액 추출
        Matcher matcher = MONEY_PATTERN.matcher(message);

        String amount = "0";

        if (matcher.find()) {
            amount = matcher.group(1);
        }

        // 2. 가맹점 및 카테고리 추출
        String merchant = "알 수 없음";
        String category = "기타";

        for (String store : categories.keySet()) {

            if (message.contains(store)) {

                merchant = store;
                category = categories.get(store);

                break;
            }
        }

        // 3. 분석 결과 객체 생성
        return new result(merchant, amount, category);
    }
}

//Pattern활용
//금액을 추출할 때 정규식은 항상 동일하기때문에 final을 사용
//private static final Pattern MONEY_PATTERN =
//Pattern.compile("([0-9,]+)원");


//카테고리 저장 키,벨류
//key:홍콩반점 value:식비  키는 가맹점 벨류는 카테고리
//private static final Map<String, String> categories = Map.of(
//	    "홍콩반점", "식비",
//	    "스타벅스", "카페",
//	    "대구 지하철", "교통"
//	);


//가맹점 찾기
//contains() ture나 false로 반환
//① categories.keySet()맵에 저장된 모든 키값을 가져옴
//그래서 for each문으로 하나씩 꺼내서 확인하기
//if (message.contains(store)) {
//    merchant = store;
//    category = categories.get(store);
//}

//category = categories.get(store);
//찾은 가맹점에 해당하는 카테고리를 가져옴