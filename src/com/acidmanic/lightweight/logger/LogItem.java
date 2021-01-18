/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.lightweight.logger;

/**
 *
 * @author diego
 */
public class LogItem {

    private String logType;
    private String message;

    public LogItem(String message, String logType) {
        this.logType = logType;
        this.message = message;
    }

    public LogItem(String message) {
        this.message = message;
        this.logType = LogTypes.LOG;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
