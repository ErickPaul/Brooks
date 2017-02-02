package cloudit.brooks.settergetter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by saifi45 on 10/23/2015.
 */
public class ridedestsettergetter {
    @SerializedName("status")
    public String status;

    @SerializedName("result")

    public Innerdestination innerdestination = new Innerdestination();
}
