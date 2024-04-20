package ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ipp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress myIP;
		try {
			myIP = InetAddress.getLocalHost();
			System.out.println("Địa chỉ IP của tôi là:");
	        System.out.println(myIP.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}

