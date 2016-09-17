package com.dubing.client;

import java.io.*;
import java.net.*;
public class TalkClient {
	public static void main(String args[]) {
		try{
			Socket socket=new Socket("127.0.0.1",3333);
			//向本机的3333端口发出客户请求
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			//由系统标准输入设备构造BufferedReader对象
			PrintWriter os=new PrintWriter(socket.getOutputStream());
			//由Socket对象得到输出流，并构造PrintWriter对象
			
			String readline;

			while(true){
				readline=sin.readLine(); //从系统标准输入读入一字符串
				os.println(readline);
				//将从系统标准输入读入的字符串输出到Server
				os.flush();

			}
		}catch(Exception e) {
			System.out.println("Error"+e); //出错，则打印出错信息
		}
	}
}