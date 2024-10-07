package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.schedule.Schedule;
import com.medicalclinic.api.domain.ticket.Ticket;
import com.medicalclinic.api.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createSchedule(@RequestBody Schedule schedule){
        var res = scheduleService.createSchedule(schedule);
        return ResponseEntity.ok(res);
    }
}
