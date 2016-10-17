package cn.e3mall.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class TestFastDfs {

	@Test
	public void testUpload() throws Exception {
		//1、创建一个配置文件client.conf。内容就是trackerServer的ip及端口号。
		//2、加载配置文件
		ClientGlobal.init("D:/workspaces-itcast/JavaEE27/e3-manager-web/src/main/resources/resource/client.conf");
		//3、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		//4、通过TrackerClient对象获得TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//5、创建一个StorageServer对象的引用null就可以。
		StorageServer storageServer = null;
		//6、创建一个StorageClient对象。两个构造参数TrackerServer、StorageServer
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//7、使用StorageClient对象上传图片
		String[] strings = storageClient.upload_file("D:/Documents/Pictures/images/200811281555127886.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testUploadByUtils() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("D:/workspaces-itcast/JavaEE27/e3-manager-web/src/main/resources/resource/client.conf");
		String string = fastDFSClient.uploadFile("D:/Documents/Pictures/images/a71ea8d3fd1f41348b28a674271f95cad1c85e98.jpg");
		System.out.println(string);
	}
}
