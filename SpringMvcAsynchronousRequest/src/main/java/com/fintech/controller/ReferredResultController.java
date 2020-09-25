package com.fintech.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

@Controller
public class ReferredResultController {

    private static final Logger LOGGER = Logger.getLogger(ReferredResultController.class);

    @GetMapping("/process-blocking")
    public ResponseEntity<?> handleReqSync(Model model) {
        model.addAttribute("country", "Viet Nam");
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/async-deferred-result")
    @ResponseBody
    public DeferredResult<ResponseEntity<?>> handleReqResult(Model model) {
        LOGGER.info("Received async-deferred-result request");
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();

        output.onCompletion(() -> LOGGER.info("Processing complete"));
        output.onTimeout(() -> output.setErrorResult("timeout"));
        output.onError(throwable ->
                        output.setErrorResult(ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("An error occurred.")));

        ForkJoinPool.commonPool().submit(() -> {
            LOGGER.info("Processing in separate thread");
            try {
                Thread.sleep(6*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            output.setResult(ResponseEntity.ok("ok"));
            return output;
        });
        LOGGER.info("servlet thread freed");
        output.setErrorResult(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("error."));
        return output;
    }
}
