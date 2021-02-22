package com.veraxy;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Veraxy on {2021/2/22}
 * 将字符串转换为十六进制形式
 **/
public class ToHexTools {

    public static void main(String[] args) throws IOException {
        String relativelyPath=System.getProperty("user.dir");
        // 使用FileInputStream打开文件
        try (FileInputStream fis = new FileInputStream(relativelyPath+"/target/classes/EvilClass.class")) {
            // 用于保存文件数据单个字节的变量
            int i = 0;

            // 一个计数器
            int count = 0;

            StringBuilder result = new StringBuilder();

            // 读取到文件末尾并以十六进制打印字节
            while ((i = fis.read()) != -1) {
                result.append(String.format("%02X", i));
                count++;
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(relativelyPath+"/src/main/java/com/veraxy/file.hex"));
            out.write(result.toString());
            out.close();
            System.out.printf("OK");
        }
    }
}