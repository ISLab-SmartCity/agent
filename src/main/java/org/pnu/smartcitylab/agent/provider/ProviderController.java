package org.pnu.smartcitylab.agent.provider;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.config.ApiResponseMessage;
import org.pnu.smartcitylab.agent.provider.dto.CreateProviderDTO;
import org.pnu.smartcitylab.agent.provider.dto.UpdateProviderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "[1. 업체 API]", description = "1. IoT 제공 업체 API")
@RestController
@RequestMapping("/provider")
@AllArgsConstructor
public class ProviderController {

    private ProviderService providerService;

    @Operation(summary = "업체 등록", description = "업체 등록 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @PostMapping
    public ResponseEntity<?> createProvider(@RequestBody CreateProviderDTO dto) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", providerService.createProvider(dto));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "업체 전체 목록 조회", description = "업체 전체 목록 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @GetMapping("/")
    public ResponseEntity<?> getProviderList() {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", providerService.getProviderList());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "업체 조회", description = "업체 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getProvider(@PathVariable("id") String id) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", providerService.getProvider(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "업체 정보 수정", description = "업체 정보 수정 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @PutMapping
    public ResponseEntity<?> updateProvider(@RequestBody UpdateProviderDTO dto) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", providerService.updateProvider(dto));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "업체 정보 삭제", description = "업체 정보 삭제 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProvider(@PathVariable("id") String id) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", providerService.deleteProvider(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
