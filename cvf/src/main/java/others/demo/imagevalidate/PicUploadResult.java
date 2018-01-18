package others.demo.imagevalidate;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PicUploadResult {
	private Integer error;

	private String url;

	private int width;

	private int height;

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void volidImage(String filePath) {
		File newFile = new File(filePath);
		try {
			BufferedImage image = ImageIO.read(newFile);
			if (image != null) {
				this.width = image.getWidth();
				this.height = image.getHeight();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
