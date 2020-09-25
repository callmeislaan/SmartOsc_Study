package com.fintech.soap_task_client.service;

import com.fintech.soap_task_client.config.SoapConnector;
import com.fintech.soap_task_client.generated.GetTaskRequest;
import com.fintech.soap_task_client.generated.GetTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final static String BASE_URL = "http://localhost:8080/ws";

    @Autowired
    SoapConnector soapConnector;

    //    @Scheduled(cron = "0/10 * * * * *")
    @Scheduled(fixedDelay = 5000)
    public GetTaskResponse getAllTask() {
        System.out.println("a");
        return (GetTaskResponse) soapConnector.callWebService(BASE_URL, new GetTaskRequest());
    }
}