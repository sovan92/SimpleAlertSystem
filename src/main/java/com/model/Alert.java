package com.model;

public class Alert {

    private String alertName;
    private Condition condition;
    private long intervalMilliseconds;
    private long lastChecked;

    public Alert(String alertName, Condition condition, long intervalMilliseconds) {
        this.alertName = alertName;
        this.condition = condition;
        this.intervalMilliseconds = intervalMilliseconds;
        this.lastChecked = System.currentTimeMillis();
    }

    public String getAlertName() {
        return alertName;
    }

    public boolean shouldTrigger() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastChecked >= intervalMilliseconds) {
            return condition.check();
        }
        lastChecked = currentTime;
        return false;
    }

}
