package util;

public class PathUtil {

	private static String seperator=System.getProperty("file.seperator");
	
	public static String getImgBasePath() {
		String os=System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win")) {
			basePath="D:/image/";
		}else {
			basePath="/home/image/";
		}
		
		basePath=basePath.replace("/", seperator);
		return basePath;
	}
	
	public static String getShopImagePath(long shopId) {
		String imgPath= "/upload/item/shop/"+shopId+"/";
		return imgPath.replace("/", seperator);
	}
}
