package com.dubing.server;

import java.io.*;
import java.net.*;
import java.applet.Applet;
public class TalkServer{
	public static void main(String args[]) {
		 
		try{
			ServerSocket server=null;
			try{
				server=new ServerSocket(3333);
				System.out.println("listening port 3333");
				//创建一个ServerSocket在端口3333监听客户请求
			}catch(Exception e) {
				System.out.println("can not listen to:"+e);
				//出错，打印出错信息
			}
			Socket socket=null;
			while(true){
				try{
					
					socket=server.accept();
					 
					System.out.println("this is the a new client ");
					
					
					//使用accept()阻塞等待客户请求，有客户
					//请求到来则产生一个Socket对象，并继续执行
					new CommunicateThread(socket).start();
					//多线程
				}catch(Exception e) {
					System.out.println("Error."+e);
					//出错，打印出错信息
				}
			}

		}catch(Exception e){
			System.out.println("Error:"+e);
			//出错，打印出错信息
		}
	}

	private static PrintWriter newPrintWriter(OutputStream outputStream) {
		// TODO Auto-generated method stub
		return null;
	}
}
