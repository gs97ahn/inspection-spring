package nogamsung.inspectionspring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InspectionService {

    @Value("${time.kst.inspection-begin-at}")
    private String kstBeginAt;

    @Value("${time.kst.inspection-end-at}")
    private String kstEndAt;

    public String generateMessage(String acceptLanguage) {
        String message;

        if (acceptLanguage.isBlank()) {
            if (kstBeginAt.isBlank() || kstBeginAt.equals("NULL")) {
                message = "현재 서비스 오류로 인해 서비스 이용이 어렵습니다. 잠시 후에 시도해 주세요.";
            } else {
                message = "현재 서버 점검으로 인해 서비스 이용이 어렵습니다. 예상 점검 시간은 " +
                        kstBeginAt + " ~ " + kstEndAt + " 입니다.";
            }
        } else if (acceptLanguage.contains("en")) {
            if (kstBeginAt.isBlank() || kstBeginAt.equals("NULL")) {
                message = "Service is unavailable due to unexpected error. Please try again later.";
            } else {
                message = "Inspection is ongoing. The estimated inspection time is " +
                        calculatePst(kstBeginAt) + " ~ " + calculatePst(kstEndAt) + " PST.";
            }
        } else {
            if (kstBeginAt.isBlank() || kstBeginAt.equals("NULL")) {
                message = "현재 서비스 오류로 인해 서비스 이용이 어렵습니다. 잠시 후에 시도해 주세요.";
            } else {
                message = "현재 서버 점검으로 인해 서비스 이용이 어렵습니다. 예상 점검 시간은 " +
                        kstBeginAt + " ~ " + kstEndAt + " 입니다.";
            }
        }

        return message;
    }

    private String calculatePst(String kst) {
        int pstH = Integer.parseInt(kst.substring(0, 2)) - 16;
        int pstM = Integer.parseInt(kst.substring(3, 5));

        if (pstH < 0)
            pstH = pstH + 24;

        return pstH + ":" + pstM;
    }
}
