package together;

import java.util.Scanner;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class home {

    // 가맹점별 카테고리
    static Map<String, String> categories = Map.of(
        "홍콩반점", "식비",
        "스타벅스", "카페",
        "이디야", "카페",
        "대구 지하철", "교통",
        "버스", "교통",
        "무신사", "쇼핑",
        "롯데리아", "식비"
    );

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== 카드 알림 문구 =====");
        System.out.println("카드 결제 알림 문구를 입력하세요.");
        System.out.println("종료하려면 exit를 입력하세요.");

        while (true) {

            System.out.print("\n알림 입력: ");
            String message = scanner.nextLine();

            // 종료 확인
            if (message.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 금액 추출
            Pattern pattern = Pattern.compile("([0-9,]+)원");
            Matcher matcher = pattern.matcher(message);

            String amount = "";

            if (matcher.find()) {
                amount = matcher.group(1);
            } else {
                System.out.println("금액을 찾을 수 없습니다.");
                continue;
            }

            // 가맹점 및 카테고리 추출
            String merchant = "";
            String category = "기타";

            for (String store : categories.keySet()) {

                if (message.contains(store)) {
                    merchant = store;
                    category = categories.get(store);
                    break;
                }
            }

            // 결과 출력
            System.out.println("\n===== 분석 결과 =====");
            System.out.println("가맹점: " +
                (merchant.isEmpty() ? "알 수 없음" : merchant));
            System.out.println("금액: " + amount + "원");
            System.out.println("카테고리: " + category);

        }

        scanner.close();
    }
}
