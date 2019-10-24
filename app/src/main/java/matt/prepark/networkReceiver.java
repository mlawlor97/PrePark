package matt.prepark;

/**
 * @author jawad
 */
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * This class is used to see if the user is connected to the internet when they launch the app
 */
public class networkReceiver {

    Context context;

    /**
     * Sets the context
     * @param context
     */
    public networkReceiver(Context context)
    {
        this.context = context;
    }

    /**
     * This method uses a ConnectivityManager object to figure out if the user is connected or not
     * returns true if the user is connected
     * returns false otherwise
     * @return
     */
    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);

        if (cm != null)
        {
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            if(nInfo != null)
            {
                if(nInfo.getState() == NetworkInfo.State.CONNECTED)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
