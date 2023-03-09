package nogamsung.inspectionspring.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Default Response DTO")
public class DefaultResDto<T> {

    @ApiModelProperty(position = 1, value = "code", example = "RESPONSE_CODE")
    private String responseCode;

    @ApiModelProperty(position = 2, value = "message in English", example = "Response message.")
    private String responseMessageEn;

    @ApiModelProperty(position = 3, value = "한국어 메세지", example = "응답 메세지.")
    private String responseMessageKr;

    public DefaultResDto(final String responseCode, final String responseMessageEn, final String responseMessageKr) {
        this.responseCode = responseCode;
        this.responseMessageEn = responseMessageEn;
        this.responseMessageKr = responseMessageKr;
    }
}
