package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random rand=new Random();
	
	
	public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
		String realFileName=getRandomFileName();
		String extension=getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr=targetAddr+realFileName+extension;
		File target=new File(PathUtil.getImgBasePath()+relativeAddr);
		
		//generate watermark
		try {
			Thumbnails.of(thumbnail.getInputStream())
			.size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)
			.outputQuality(0.8f)
			.toFile(target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	
	/**
	 * Recursively create directories 
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String fullPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(fullPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
	}

	/**
	 * 
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(CommonsMultipartFile oFile) {
		String oFileName=oFile.getOriginalFilename();
		return oFileName.substring(oFileName.lastIndexOf("."));
	}

	/**
	 * current datetime + 5-random-digits
	 * @return
	 */
	private static String getRandomFileName() {
		int randNum=rand.nextInt(89999)+10000;
		String curTime=sdf.format(new Date());
		return curTime+randNum;
	}
	
	
	
	
	
	
}
