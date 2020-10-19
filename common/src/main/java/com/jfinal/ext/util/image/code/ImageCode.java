package com.jfinal.ext.util.image.code;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * <p>
 * 功能描述：产生验证码图片
 * </p>
 * 
 * @author zb
 * @version 1.0
 */
public class ImageCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int defaultCodeLength = 4;
	public static final String FORMAT_PNG = "png";
	public static final String FORMAT_JPG = "jpg";
	public static final String FORMAT_JPEG = "jpeg";
	public static final String FORMAT_GIF = "gif";

	private final Font imgFont = new Font("Arial", Font.BOLD, 15); // 设置字体
	// 生成随机类
	private final Random random = new Random();
	private final Integer codeLength;
	private BufferedImage image = null;
	private String randCode = null;
	private int lineWidth = 2; // 干扰线的长度=1.414*lineWidth
	private int width = 60; // 定义图形大小
	private int height = 20; // 定义图形大小
	private int count = 200;

	protected ImageCode() {
		this(defaultCodeLength);
	}

	protected ImageCode(int codeLength) {
		this.codeLength = codeLength;
	}

	private Color getRandColor(int fc, int bc) { // 取得给定范围随机颜色
		Random random = new Random();
		if (fc > 255) fc = 255;

		if (bc > 255) bc = 255;

		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);

		return new Color(r, g, b);
	}

	public String getRandCode(){
		return getRandCode(codeLength);
	}

	public String getRandCode(int length){
		if(null == randCode){
			// 取随机产生的认证码(4位数字)
			StringBuilder sRand = new StringBuilder();
			// char[] selectChar = new
			// char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			// zb 2015-1-4 去除奇异字符 去除0 O o I i L l
			char[] selectChar = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
					'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
					'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
			for (int i = 0; i < length; i++) {
				int charIndex = random.nextInt(selectChar.length);
				String rand = String.valueOf(selectChar[charIndex]);
				sRand.append(rand);
			}
			this.randCode = sRand.toString();
		}
		return randCode;
	}

	public BufferedImage getBufferedImage(){
		if(null == this.image){
			// 在内存中创建图象
			this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			// 获取图形上下文
			Graphics2D g = (Graphics2D) image.getGraphics();

			// 设定背景色
			g.setColor(getRandColor(200, 250)); // ---1

			g.fillRect(0, 0, width, height);

			// 设定字体
			g.setFont(imgFont);

			// 画边框
			g.setColor(getRandColor(0, 20)); // ---2
			g.drawRect(0, 0, width - 1, height - 1);

			// 随机产生干扰线，使图象中的认证码不易被其它程序探测到
			for (int i = 0; i < count; i++) {
				g.setColor(getRandColor(150, 200)); // ---3

				int x = random.nextInt(width - lineWidth - 1) + 1; // 保证画在边框之内
				int y = random.nextInt(height - lineWidth - 1) + 1;
				int xl = random.nextInt(lineWidth);
				int yl = random.nextInt(lineWidth);
				g.drawLine(x, y, x + xl, y + yl);
			}

			char[] chars = randCode.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				// 将认证码显示到图象中,调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
				g.setColor(new Color(20 + random.nextInt(130),
						20 + random.nextInt(130),
						20 + random.nextInt(130))); // --4--50-100
				g.drawString(String.valueOf(chars[i]), (13 * i) + 6, 16);
			}

			// 图象生效
			g.dispose();
		}
		return this.image;
	}

	public void writeImg(OutputStream outputStream) throws IOException {
		ImageIO.write(getBufferedImage(), FORMAT_PNG, outputStream);
	}

	public void writeImg(String imgFormat, OutputStream outputStream) throws IOException {
		ImageIO.write(getBufferedImage(), imgFormat, outputStream);
	}


	// generate getter and setter
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Font getImgFont() {
		return imgFont;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getCount() {
		return count;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
