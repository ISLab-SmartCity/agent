package org.pnu.smartcitylab.agent.daq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.config.ApiResponseMessage;
import org.pnu.smartcitylab.agent.daq.dto.DaqDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "[3. 센싱 데이터 API]", description = "3. IoT 센싱 데이터 API")
@CrossOrigin("*")
@RestController
@RequestMapping("/daq")
@AllArgsConstructor
public class DAQController {
    private DAQService daqService;

    @Operation(summary = "센싱 데이터 등록", description = "센싱 데이터 등록 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @PostMapping
    public ResponseEntity<?> createDaq(@RequestBody DaqDTO dto) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", daqService.createData(dto));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "센싱 데이터 조회", description = "센싱 데이터 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ApiResponseMessage.class)))
    })
    @GetMapping("/{device_id}")
    public ResponseEntity<?> getDaqList(@PathVariable("device_id") String device_id) {
        ApiResponseMessage result = null;
        try {
            result = new ApiResponseMessage(true, "Success", "", "", daqService.getDaq(device_id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result = new ApiResponseMessage(false, "Failure", "", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
