package com.cz.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.cz.service.Mqtt.MqttSender;
import com.cz.service.Mqtt.MqttUtil;

/**
 * Author       wildma
 * Github       https://github.com/wildma
 * CreateDate   2018/11/08
 * Desc         ${MQTT服务}
 */
public class MyMqttService extends Service {

    public static final String TAG = "MQTTf服务：MyMqttService";

    public static String MQTT_HOST = "tcp://47.111.11.222:61613";
    public static String MQTT_SERVER_NAME = "xiaoduo88";
    public static String MQTT_USER_NAME = "admin";
    public static String MQTT_PASS_WORD = "password";
    public static String MQTT_TOPIC_SUB = "newzldToApp/open/1576";
    public static String MQTT_TOPIC_HEART = "appToNewZld/heart/1576";

    public static boolean MqttState = false;


    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (!(MqttState = MqttUtil.getInstance().start())){

                    try { Thread.sleep(5000); } catch (InterruptedException e) { }
                }
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //发送MQTT心跳
        if (intent.getStringExtra("text")==null && MqttState){

            MqttSender.sendMessage(MQTT_TOPIC_HEART,"",0);
        }

        return super.onStartCommand(intent, flags, startId);
    }

}
