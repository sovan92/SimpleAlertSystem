package com.main;

import com.model.Condition;
import com.service.AlertExecutionEngine;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Example Usage:

        // Dummy condition implementation
        Condition dummyCondition = () -> true; // Replace this with your actual condition logic

        // Create an instance of the AlertExecutionEngine
        AlertExecutionEngine alertEngine = new AlertExecutionEngine();

        // Add an alert with a dummy condition and check interval of 5 seconds
        alertEngine.addAlert("HighTemperature", dummyCondition, 3);

        // Add another alert with a different dummy condition and check interval of 10 seconds
        alertEngine.addAlert("LowDiskSpace", dummyCondition, 3);

        // Start the alert engine



        alertEngine.start();

        // Note!!! Keep the statement underneath turned on if you need to test the scheduler.
        Thread.sleep(100000);

    }
}
