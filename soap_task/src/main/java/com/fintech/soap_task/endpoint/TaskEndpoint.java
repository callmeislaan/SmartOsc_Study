package com.fintech.soap_task.endpoint;

import com.fintech.soap_task.service.TaskService;
import fintech.com.GetTaskResponse;
import fintech.com.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.stream.Collectors;

@Endpoint
public class TaskEndpoint {
    private static final String NAMESPACE_URI = "http://com.fintech";

    @Autowired
    TaskService taskService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTaskRequest")
    @ResponsePayload
    public GetTaskResponse getTaskResponse() {
        GetTaskResponse taskResponse = new GetTaskResponse();
        taskResponse.getTasks()
                .addAll(taskService.getAllByOrderByPriorityDesc().stream()
                        .map(task -> {
                            Task taskXsd = new Task();
                            taskXsd.setId(task.getId().intValue());
                            taskXsd.setName(task.getName());
                            taskXsd.setPriority(task.getPriority().name());
                            taskXsd.setPersonId(task.getPersonId().intValue());
//                            BeanUtils.copyProperties(task, taskXsd);
                            return taskXsd;
                        })
                        .collect(Collectors.toList()));
        return taskResponse;
    }
}
