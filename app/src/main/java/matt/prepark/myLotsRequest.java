package matt.prepark;
/**
 * @author jawad
 */

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * This class sends info taken from the myLots class to the database
 */

public class myLotsRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://proj-309-sb-b-2.cs.iastate.edu/mylots.php";
    private Map<String, String> params;

    /**
     * This method sends the follwing to the database:
     * @param address
     * @param spots
     * @param time
     * @param username
     * @param listener
     */
    public myLotsRequest(String address, String spots, String time, String username, Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("address", address);
        params.put("spots", spots);
        params.put("time", time);
        params.put("username", username);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
