package com.socialmedia.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "analytics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metricName;
    private int metricValue;

    // Explicitly add the setter for ID
    public void setId(Long id) {
        this.id = id;
    }
}
