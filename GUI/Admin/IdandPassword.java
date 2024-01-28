package GUI.Admin;

import java.util.HashMap;

public class IdandPassword {
    // creates a dictionary to store the userId and Password as key value pairs
    private HashMap<String, String> logininfo = new HashMap<String, String>();

    public IdandPassword() {
        logininfo.put("leykun", "abc123"); // this are dummy datas but we can change it later
        logininfo.put("kidus", "itworks!");
        logininfo.put("fikr", "agoo");

    }

    public HashMap getLogInfo() {
        return logininfo;
    }
}
