package matt.prepark;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;

/**
 * Created by mattlawlor on 12/2/17.
 * @author mattlawlor
 */

/**
 * increment or decrement the amount of spots in a lot
 */
public class SpotAmountRequest extends StringRequest {
    private static final String MAP_REQUEST_URL = "http://proj-309-sb-b-2.cs.iastate.edu/spotAmount.php";
    private java.util.Map<String, String> params;

    /**
     *
     * @param address
     * @param taken
     * @param listener
     * give the address and let it know if you are increasing or decreasing the number of spots
     */
    public SpotAmountRequest(String address, String taken, Response.Listener<String> listener) {
        super(Request.Method.POST, MAP_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("address", address);
        params.put("taken", taken);
    }

    @Override
    public java.util.Map<String, String> getParams() {
        return params;
    }
}
