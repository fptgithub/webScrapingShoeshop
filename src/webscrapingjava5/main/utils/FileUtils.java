package webscrapingjava5.main.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileUtils {
	static String folder = "./image";

	public static String getFileName(String url) {
		return url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".")+4);
	}
	
	public static File checkFilePath(String path) {
		File file = new File(path.substring(0,path.lastIndexOf("/")));
		if(!file.exists()) {
			file.mkdir();
		}
		return new File(path);
	}
	
	public static void downloadFile(String url) throws Exception{
		URL web = new URL(url);
		try (InputStream in = web.openStream()){
	            ReadableByteChannel rbc = Channels.newChannel(in);
	            FileOutputStream fos = new FileOutputStream(checkFilePath(folder+getFileName(url)));
	            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	        }
	}
	
}
