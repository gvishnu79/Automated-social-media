package com.socialmedia.services;

import com.socialmedia.models.Analytics;
import com.socialmedia.repositories.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    public List<Analytics> getAllAnalytics() {
        return analyticsRepository.findAll();
    }

    public Analytics getAnalyticsById(Long id) {
        return analyticsRepository.findById(id).orElse(null);
    }

    public Analytics createAnalytics(Analytics analytics) {
        return analyticsRepository.save(analytics);
    }

    public Analytics updateAnalytics(Long id, Analytics updatedAnalytics) {
        if (analyticsRepository.existsById(id)) {
            updatedAnalytics.setId(id);
            return analyticsRepository.save(updatedAnalytics);
        }
        return null;
    }

    public void deleteAnalytics(Long id) {
        analyticsRepository.deleteById(id);
    }
}
