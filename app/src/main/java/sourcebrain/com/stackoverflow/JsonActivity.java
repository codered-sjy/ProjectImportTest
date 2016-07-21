package sourcebrain.com.stackoverflow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sujay on 18-07-2016.
 */
public class JsonActivity extends AppCompatActivity {

    String jsonResult = "[{'guid':'C410B2AA-EC03-29E4-F5C0-CB48510ED9E5','id':'2','created_on':'2016-05-17 13:13:22','car_name':'Hundai','model':'C001','version':'i20','make_year':'2012','kms_driven':'2000','city':'Bangalore','pincode':'560072','expected_price':'200000','name':'Vishnu','email':'dreamvishnu@gmail.com','mobile':'9863265358','image':[{'newimage':'https://images.cardekho.com/car-images/carexteriorimages/large/Ford/Ford-Mustang/ford-mustang-exterior-047.jpg'},{'newimage':'https://www.enterprise.com/content/dam/global-vehicle-images/cars/FORD_FOCU_2012-1.png'},{'newimage':'https://imagecdn8.cartrade.com/img/800x600/car-data/big/bmw-i8-default-image.png'}]}]";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            JSONArray object = new JSONArray(jsonResult);
            ArrayList<String> items = new ArrayList<String>();
            JSONArray vehicleSliderIamges = null;
            try {
                for (int i = 0; i < object.length(); i++) {
                    JSONObject obj = object.getJSONObject(i);
                    vehicleSliderIamges = obj.getJSONArray("image");


                }
                ArrayList<String> list = new ArrayList<String>();
                if (vehicleSliderIamges != null) {
                    int len = vehicleSliderIamges.length();
                    for (int i=0;i<len;i++){
                        list.add(vehicleSliderIamges.get(i).toString());
                    }
                }

                System.out.println(vehicleSliderIamges.length() + " size" + " " + list.get(0).toString());



            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("log_tag", "Error parsing data " + e.toString());
        }


    }
}
