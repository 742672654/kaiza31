package com.cz.service.Mqtt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.cz.activity.ZldNew2Activity;
import com.cz.bean.MqttBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.eclipse.paho.client.mqttv3.MqttClient;

/**
 * 类名称：MqttSender    
 * 类描述：MQTT读
 * 创建人：kanghuibin  
 * 创建时间：2018-8-4 下午03:54:41    
 * 修改人：kanghuibin   
 * 修改时间：2017-8-4 下午03:54:41    
 * 修改备注：    
 * @version 1.0  
 */
public class MqttReadThread extends Thread{


	public static final String TAG = "MqttReadThread<接收数据>";

	String topic ;
	String message ;
	MqttClient client;

	
	public MqttReadThread(String topic, String message, MqttClient client) {
		this.topic = topic;
        this.message = message;
        this.client = client;
    }
	
	public void run() {

		try {

			Log.i(TAG, "topic=" + topic + ";message=" + message);
			MqttBean mqttBean = new Gson().fromJson(message, new TypeToken<MqttBean>() {
			}.getType());


			Bundle bundle = new Bundle();
			bundle.putString("joinType", TAG);
			Message message = new Message();
			message.what = ZldNew2Activity.out_MQttPush;
			message.obj = mqttBean;
			message.setData(bundle);
			Handler handler = ZldNew2Activity.zldNew2Activity.getHandler();
			handler.sendMessage(message);

		} catch (Exception e) {
			Log.w(TAG, e);
		}
	}
}
