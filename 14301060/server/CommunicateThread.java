package com.dubing.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


//每有一个连接建立时，服务器分出一个通信的线程
public class CommunicateThread extends Thread{
	
	
	//与客户端通信的套接字
	Socket client;

	public CommunicateThread(Socket s) {
		client = s;
	}


	public void run(){
		try{
		    
			while(true){
				//构造相应的BufferedReader对象
				
				BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));
				//接收客户端的信息
				String accept=is.readLine();
				System.out.println("reverse:"+reverse(accept));	
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}		
	}
	public static String reverse(String before_reverse){

		char ch[] = before_reverse.toCharArray();
		int start = 0, end = ch.length-1;
		char temp;
		while(start<end){
			temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
		String reverse = String.copyValueOf(ch);
		return reverse ;

	}
}



