package nogamsung.inspectionspring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import nogamsung.inspectionspring.common.DefaultResDto;
import nogamsung.inspectionspring.service.InspectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@Api(tags = "Inspection")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InspectionController {

    private final InspectionService inspectionService;

    @ApiOperation("Message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "503", description = "ONGOING_INSPECTION",
                    content = @Content(schema = @Schema(implementation = Object.class)))
    })
    @RequestMapping(value = {"/**", "/**/**", "/**/**/**",
            "/**/**/**/**", "/**/**/**/**/**", "/**/**/**/**/**/**",
            "/**/**/**/**/**/**/**", "/**/**/**/**/**/**/**/**", "/**/**/**/**/**/**/**/**/**"})
    @ResponseStatus(SERVICE_UNAVAILABLE)
    public ResponseEntity<DefaultResDto<Object>> sendInspectionMessage(HttpServletRequest servletRequest) {

        String acceptLanguage = servletRequest.getHeader("Accept-Language");

        String msg = inspectionService.generateMessage(acceptLanguage);


        return ResponseEntity.status(SERVICE_UNAVAILABLE)
                .body(DefaultResDto.builder()
                        .responseCode("ONGOING_INSPECTION")
                        .responseMessage(msg)
                        .build());
    }
}
