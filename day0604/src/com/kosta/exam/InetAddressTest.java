package com.kosta.exam;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        try {
//			InetAddress addr = InetAddress.getByName("www.naver.com");
//			System.out.println(addr);

            InetAddress[] arr =
                    InetAddress.getAllByName("www.naver.com");
            for (InetAddress addr : arr) {
                System.out.println(addr);
            }


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
