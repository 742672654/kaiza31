package com.cz.Shared;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.cz.util.TimeUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zld.bean.CarType;

import java.util.List;

//车辆类型
public class CarType_Shared {



    private static final String TAG = "CarType_Shared";

    /**
     * 判断某个xml是否存在
     *
     * @param context
     */
    public static boolean isExistence(Context context) {


        return BaseShared.isExistence(context, "CarType");
    }


    /**
     * 返回xml所有参数
     *
     * @param context
     */
    public static List<CarType> getALL(Context context) {

        try {

            String carTypeString = BaseShared.getALL(context, "CarType", String.class);
            CarType_SharedBean carType_SharedBean = new Gson().fromJson(carTypeString, new TypeToken<CarType_SharedBean>(){}.getType());
            List<CarType> carTypeList = new Gson().fromJson(carType_SharedBean.getCarType(), new TypeToken<List<CarType>>(){}.getType());
            return carTypeList;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    /**
     * 对象保存参数到xml
     *
     * @param context
     */
    public static boolean saveALL(Context context, List<CarType> carType) {


        try {

            Log.i( TAG,carType.toString());

            SharedPreferences spf2 = context.getSharedPreferences("CarType", Context.MODE_PRIVATE);
            SharedPreferences.Editor spfEdit2 = spf2.edit();
            spfEdit2.clear();
            spfEdit2.commit();


            SharedPreferences spf = context.getSharedPreferences("CarType", Context.MODE_PRIVATE);
            SharedPreferences.Editor spfEdit = spf.edit();
            spfEdit.putBoolean("existence", true);

            spfEdit.putString("carType", new Gson().toJson(carType));

            spfEdit.putString("existence_time", TimeUtil.getDateTime());
            spfEdit.commit();
            return true;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return false;
    }


}

class CarType_SharedBean{

  private boolean existence;
  private String existence_time;
  private String carType;

    public boolean isExistence() {
        return existence;
    }
    public void setExistence(boolean existence) {
        this.existence = existence;
    }
    public String getExistence_time() {
        return existence_time;
    }
    public void setExistence_time(String existence_time) {
        this.existence_time = existence_time;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }

}