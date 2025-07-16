package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String actionCode = "";
    private String index ="";

    private Map<String, String> params = new HashMap<>();

    public Request(String command) {
        String[] commandList = command.split("\\?", 2);
        this.actionCode = commandList[0].trim();

        if (commandList.length == 1) return;

        String[] paramList = commandList[1].split("&", 2);
        for (String paramRow : paramList) {
            String[] paramStr = paramRow.split("=", 2);
            if (paramStr.length == 2) {
                String key = paramStr[0].trim();
                String value = paramStr[1].trim();
                this.params.put(key, value);
            }
        }
    }

    public String getActionCode() {
        return this.actionCode;
    }

    public String getIndex() {
        return this.index;
    }

    public String getParam(String key) {
        return this.params.get(key);
    }
}
