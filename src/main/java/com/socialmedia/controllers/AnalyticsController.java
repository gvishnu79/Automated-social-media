package com.socialmedia.controllers;

import com.socialmedia.models.Analytics;
import com.socialmedia.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping
    public List<Analytics> getAllAnalytics() {
        return analyticsService.getAllAnalytics();
    }

    @GetMapping("/{id}")
    public Analytics getAnalyticsById(@PathVariable Long id) {
        return analyticsService.getAnalyticsById(id);
    }

    @PostMapping
    public Analytics createAnalytics(@RequestBody Analytics analytics) {
        return analyticsService.createAnalytics(analytics);
    }

    @PutMapping("/{id}")
    public Analytics updateAnalytics(@PathVariable Long id, @RequestBody Analytics analytics) {
        return analyticsService.updateAnalytics(id, analytics);
    }

    @DeleteMapping("/{id}")
    public void deleteAnalytics(@PathVariable Long id) {
        analyticsService.deleteAnalytics(id);
    }
}
