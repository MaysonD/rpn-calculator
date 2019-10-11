package com.example.rpn.api;

import com.example.rpn.dto.Request;
import com.example.rpn.dto.RpnResponse;
import com.example.rpn.service.RpnService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Stack;

@CrossOrigin
@RequestMapping("/rpn")
@RestController
public class CalcController {

    private RpnService rpnService;

    public CalcController(RpnService rpnService) {
        this.rpnService = rpnService;
    }

    @PostMapping(path = "/convert", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns expression in rpn format", response = RpnResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Successfully retrieved rpn expression")
    })
    public ResponseEntity<RpnResponse> calculateExpression(@RequestBody @Valid Request request) {
        try {
            RpnResponse rpnResponse = rpnService.calculate(request);
            return ResponseEntity.status(HttpStatus.OK).body(rpnResponse);
        } catch (NumberFormatException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
