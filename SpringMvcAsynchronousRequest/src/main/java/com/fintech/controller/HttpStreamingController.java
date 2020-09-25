package com.fintech.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class HttpStreamingController {

    @GetMapping("/streaming")
    public ResponseBodyEmitter handleRequest() {
        final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    emitter.send(i + " - ", MediaType.TEXT_PLAIN);
                    Thread.sleep(50);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        });
        return emitter;
    }


    @GetMapping("/executor")
    public SseEmitter handleRbe() {
        final SseEmitter emitter = new SseEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    emitter.send("/rbe" + " @ " + new Date() + "\n", MediaType.TEXT_PLAIN);
                    Thread.sleep(10);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        });
        return emitter;
    }

    @GetMapping("/streaming-response-body")
    public StreamingResponseBody handleStreamingResponseBody() {
        return outputStream -> {
            for (int i = 0; i < 1000; i++) {
                String msg = "/srb" + " @ " + new Date() + "\n";
                outputStream.write(msg.getBytes());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
