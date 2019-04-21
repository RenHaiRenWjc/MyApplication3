package com.example.javaproject.proxy;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

/**
 * ClassName:com.example.javaproject.proxy
 * Description:
 * author:wjc on 2019/4/21 16:19
 */
public class ProxyUtils {
    /*   byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
               proxyName, interfaces, accessFlags);*/
    public static void generateClassFile(Class clazz, String proxyName) {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, new Class[]{clazz});
        String paths = clazz.getResource(".").getPath();
        System.out.println(paths);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(paths + proxyName + ".class");
            outputStream.write(proxyClassFile);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
