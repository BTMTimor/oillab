package com.jfinal.ext.util.image.code;

/*
    author: 江理网猿
    date: 2020/9/10 0010
*/
public class ImgCodeFactory {
    public static final int DEFAULT_IMG_CODE_WIDTH = 60; // 定义验证码图形大小
    private static final int DEFAULT_IMG_CODE_LENGTH = 4; // 验证码默认字符数
    private static final int DEFAULT_IMG_CODE_LINE_WIDTH = 2; // 干扰线的长度=1.414*lineWidth
    private static final int DEFAULT_IMG_CODE_HEIGHT = 20; // 定义图形大小
    private static final int DEFAULT_IMG_CODE_COUNT = 200;

    public static ImageCode newImageCode(){
        ImageCode imageCode = new ImageCode(DEFAULT_IMG_CODE_LENGTH);
        imageCode.setHeight(DEFAULT_IMG_CODE_HEIGHT);
        imageCode.setWidth(DEFAULT_IMG_CODE_WIDTH);
        imageCode.setLineWidth(DEFAULT_IMG_CODE_LINE_WIDTH);
        imageCode.setCount(DEFAULT_IMG_CODE_COUNT);
        return imageCode;
    }

}
