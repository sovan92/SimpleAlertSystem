package com.service;

import com.model.Condition;
import com.model.Alert;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class AlertExecutionEngine {

    private Map<String, Alert> alerts;

    public AlertExecutionEngine() {
        this.alerts = new HashMap<>();
    }

    public void addAlert(String alertName, Condition condition, long intervalMilliseconds) {
        Alert alert = new Alert(alertName, condition, intervalMilliseconds);
        alerts.put(alertName, alert);
    }

    public void start() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkAlerts();
            }
        }, 0, 1000); // Check alerts every second (adjust as needed)
    }

    private void checkAlerts() {
        for (Alert alert : alerts.values()) {
            if (alert.shouldTrigger()) {
                sendNotification(alert.getAlertName());
            }
        }
    }

    private void sendNotification(String alertName) {
        // Placeholder for sending notifications.
        // Implement your notification mechanism here.
        System.out.println("Alert '" + alertName + "' violated the condition! Sending notification.");
    }




}
