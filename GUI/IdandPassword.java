package GUI;
import java.util.HashMap;

public class IdandPassword {
    //creates a dictionary to store the userId and Password as key value pairs
    private static HashMap<String,String> logininfo = new HashMap<String,String>();
    IdandPassword(){
        logininfo.put("leykun","abc123"); //this are dummy datas but we can change it later
        logininfo.put("kidus","itworks!");
        

    }
    protected static HashMap getLogInfo(){
        return logininfo;
    }
}
