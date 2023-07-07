package org.pnu.smartcitylab.agent.device;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.config.ApiResponseMessage;
import org.pnu.smartcitylab.agent.device.dto.CreateDeviceDTO;
import org.pnu.smartcitylab.agent.device.dto.UpdateDeviceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "[2. 기기 API]", description = "2. IoT 기기 API")
@CrossOrigin("*")
@RestController
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceController {
    private DeviceService deviceService;

    @Operation(summary = "기기 등록", description = "기기 등록 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @PostMapping
    public ResponseEntity<?> createDevice(@RequestBody CreateDeviceDTO dto) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", deviceService.createDevice(dto));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "기기 전체 목록 조회", description = "기기 전체 목록 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @GetMapping("/")
    public ResponseEntity<?> getDeviceList() {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", deviceService.getDeviceList());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "기기 조회", description = "기기 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getDevice(@PathVariable("id") String id) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", deviceService.getDevice(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "기기 수정", description = "기기 수정 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @PutMapping
    public ResponseEntity<?> updateDevice(@RequestBody UpdateDeviceDTO dto) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", deviceService.updateDevice(dto));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "기기 삭제", description = "기기 삭제 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable("id") String id) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", deviceService.deleteDevice(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
