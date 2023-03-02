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

    @ApiModelProperty(position = 2, value = "message", example = "Response message.")
    private String responseMessage;

    public DefaultResDto(final String responseCode, final String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
}
