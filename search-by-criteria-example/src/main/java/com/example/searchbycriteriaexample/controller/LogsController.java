package com.example.searchbycriteriaexample.controller;

import com.example.searchbycriteriaexample.model.Log;
import com.example.searchbycriteriaexample.model.dto.NewLog;
import com.example.searchbycriteriaexample.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/logs")
public class LogsController {
    private final LogService logsService;

    @PostMapping("/add")
    public Log addLog(@RequestBody NewLog newLog) {
        return logsService.addLog(newLog);
    }

    @GetMapping("/search")
    public List<Log> searchLogs(@RequestParam("fields") List<String> fields,
                                @RequestParam("term") String term) {
        return logsService.searchLogs(fields, term);
    }
}
