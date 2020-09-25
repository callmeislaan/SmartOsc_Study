package com.fintech.wsbl_demo;

import com.fintech.GetMinusRequest;
import com.fintech.GetMinusResponse;
import com.fintech.GetPlusRequest;
import com.fintech.GetPlusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.jws.WebMethod;

@Endpoint
public class ComputeEndpoint {
    //    private static  final String NAMESPACE_URI="http://spring.io/guides/gs-producing-web-service";
    private static final String NAMESPACE_URI = "http://fintech.com";

    @Autowired
    ComputeRepository computeRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlusRequest")
    @ResponsePayload
    public GetPlusResponse getPlusResponse(@RequestPayload GetPlusRequest request) {
        return computeRepository.plus(request.getNumbers());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMinusRequest")
    @ResponsePayload
    public GetMinusResponse getMinusResponse(@RequestPayload GetMinusRequest request) {
        return computeRepository.minus(request.getNumbers());
    }
}
