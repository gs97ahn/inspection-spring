package nogamsung.inspectionspring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InspectionService {

    @Value("${time.kst.inspection-begin-at}")
    private String kstBeginAt;

    @Value("${time.kst.inspection-end-at}")
    private String kstEndAt;

    @Value("${time.pst.inspection-begin-at}")
    private String pstBeginAt;

    @Value("${time.pst.inspection-end-at}")
    private String pstEndAt;

    public String krInspectionMessage() {
        return "현재 서버 점검으로 인해 서비스 이용이 어렵습니다. 예상 점검 시간은 " +
                kstBeginAt + " ~ " + kstEndAt +
                " 입니다.";
    }

    public String enInspectionMessage() {
        return "A server inspection is ongoing. The estimated inspection time is " +
                pstBeginAt + " ~ " + pstEndAt +
                " PST.";
    }
}
