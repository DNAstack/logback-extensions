package com.dnastack.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;

import java.util.Map;

public class StackdriverJsonLayout extends JsonLayout {

    @Override
    protected Map toJsonMap(ILoggingEvent event) {
        Map result = super.toJsonMap(event);
        result.putIfAbsent("severity", result.getOrDefault(JsonLayout.LEVEL_ATTR_NAME, "INFO"));
        return result;
    }
}
