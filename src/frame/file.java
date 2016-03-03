package frame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class file {
	public static void createfile(){
		String str = "{\"configs\" : [  {\"server\" : \"45.78.54.144\",\"server_port\" : 443,\"password\" : \"OTBiYjYxYz\",\"method\" : \"aes-256-cfb\",\"remarks\" : \"\"}],\"index\" : 0,\"global\" : false,";
		str += "\"enabled\" : true,\"shareOverLan\" : true,\"isDefault\" : false,\"localPort\" : 1080,\"pacUrl\" : null,\"useOnlinePac\" : false}";
//		String pathname = "F:\\shadowsocks\\shadowsocks_for_win\\gui-config.json";
		String pathname = "F:\\gui-config.json";
		try {
			java.io.File f = new java.io.File(pathname);
			if (f.exists()){
				System.out.print("文件存在");
			} else{
				System.out.print("文件不存在");  
                f.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(str);
            output.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deletefile(){
		String pathname = "F:\\gui-config.json";
		try {
			java.io.File f = new java.io.File(pathname);
            f.delete();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void run() {
		String cmd = "F:\\shadowsocks\\shadowsocks_for_win\\Shadowsocks.exe";
		Runtime run = Runtime.getRuntime();
		try {
			Process p = run.exec(cmd);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
