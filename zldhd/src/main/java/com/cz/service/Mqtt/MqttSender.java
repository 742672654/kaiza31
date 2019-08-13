package com.cz.service.Mqtt;


import android.util.Log;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;



/**
 * 类名称：MqttSender    
 * 类描述：消息队列发送端
 * 创建人：kanghuibin  
 * 创建时间：2018-8-4 下午03:54:41    
 * 修改人：wuyongde   
 * 修改时间：2018-8-4 下午03:54:41    
 * 修改备注：    
 * @version 1.0  
 */
public class MqttSender {

    private final static String TAG = "MqttSender<MQTT发送数据>";
	/**
	 * 发布消息到指定的队列
	 * @param topic :队列名称
	 * @param message :消息
	 * @param qos :消息服务质量 (0:允许消息丢失场景（性能最高）,1:不允许消息丢失，但允许消息重复场景（性能中等）,2:不允许消息丢失，且不允许消息重复场景（性能最差）)
	 */
	public static void sendMessage(String topic,String message,int qos){
		
		try {
            Log.i(TAG,"topic="+topic+";message="+message+";qos="+qos);

			MqttMessage mqttMessage = new MqttMessage(message.getBytes("utf-8"));
			mqttMessage.setQos(qos);

            MqttUtil.getClient().publish(topic, mqttMessage);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
