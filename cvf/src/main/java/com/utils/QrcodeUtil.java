  package com.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrcodeUtil {
	//创建二维码
	public static String createImg (String fileName,String content,String savePath) throws IOException, WriterException{
        // 检查目录
        File uploadDir = new File(savePath);
        if (!uploadDir.isDirectory()) {
        	uploadDir.mkdirs();
        }
        // 检查目录写权限
        if (!uploadDir.canWrite()) {
            return null;
        }
        savePath =savePath+fileName+".png";//文件生成路径
		//create(content, BarcodeFormat.QR_CODE, 300, 300, savePath, "jpeg");
		//String tempPath = "/gameQrcode/"+fileName+".jpeg";
        
        create(content, BarcodeFormat.QR_CODE, 300, 300, savePath, "png");
        String tempPath = "/gameQrcode/"+fileName+".png";

		return tempPath;
	}
	
	public static void create(String input, BarcodeFormat fromat, int canvasWidth, int canvasHeight, String outputFileName, String formatName) throws WriterException, IOException {
		QRCodeWriter writer = new QRCodeWriter();
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
	    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
	    hints.put(EncodeHintType.MARGIN, 0);//边距
	    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); //容错率  L:7%; M:15%; Q:25%; H:30%; 容错率越高，越容易被快速扫描
	    
		BitMatrix matrix = writer.encode(input, fromat, canvasWidth, canvasHeight, hints);

		BufferedImage image = createImageFromMatrix(matrix);
		File file = new File(outputFileName);
		ImageIO.write(image, formatName, file);
    }
	
	private static BufferedImage createImageFromMatrix(BitMatrix matrix) {
	    int width = matrix.getWidth();
	    int height = matrix.getHeight();
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    
	    for (int x = 0; x < width; x++) {
	    	for (int y = 0; y < height; y++) {
	    		image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
	    	}
	    }
	    
	    return image;
	}
}
