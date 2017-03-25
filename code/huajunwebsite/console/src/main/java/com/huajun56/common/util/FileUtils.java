/*
 * Copyright (c) 2015. Bond(China)
 */
package com.huajun56.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * 文件操作工具
 *
 * @author Bond(China)
 */
public final class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
    }

    /**
     * 复制文件到指定目录，如果src为路径，则只复制其名下的所有子目录和子文件
     *
     * @param src  可为路径，也可是文件
     * @param dest 必需为路径
     */
    public static void copy(File src, File dest) {
        if (dest.isFile()) {
            return;
        }
        if (src.isDirectory()) {
            copyFolder(src, dest);
            return;
        }
        File realFile = new File(dest.getAbsoluteFile() + "/" + src.getName());
        if (!realFile.exists()) {
            try {
                realFile.createNewFile();
            } catch (IOException e) {
                LOGGER.error("[Create file error]", e);
            }
        }
        copyFile(src, realFile);
    }

    private static void copyFile(File src, File realFile) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(src);
            fo = new FileOutputStream(realFile);
            in = fi.getChannel();
            out = fo.getChannel();
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            LOGGER.error("[Transfer Channel error]", e);
        } finally {
            close(fi);
            close(in);
            close(fo);
            close(out);
        }
    }

    private static void copyFolder(File src, File dest) {
        File[] files = src.listFiles();
        for (File subFile : files) {
            File subDest = dest;
            if (subFile.isDirectory()) {
                subDest = new File(dest.getAbsolutePath() + "/" + subFile.getName());
            }
            if (!subDest.exists()) {
                subDest.mkdir();
            }
            copy(subFile, subDest);
        }
    }

    /**
     * 删除单个文件
     *
     * @param sPath 被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        File file = new File(sPath);
        if (file.isFile() && file.exists()) {
            file.delete();
            return true;
        }
        return false;
    }

    /**
     * 读取文件
     *
     * @param file 需要读取的文件
     * @return String
     */
    public static String read(File file) {
        InputStream inputStream = null;
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = new FileInputStream(file);
            byte[] bts = new byte[1024];
            int len = inputStream.read(bts);

            while (len != -1) {
                sb.append(new String(bts, 0, len));
                len = inputStream.read(bts);
            }
        } catch (Exception e) {
            LOGGER.error("[FileUtils read file]", e);
        } finally {
            close(inputStream);
        }
        return sb.toString();
    }

    /**
     * 关闭文件流
     *
     * @param in InputStream
     */
    public static void close(InputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                LOGGER.error("[Close file steam error]", e);
            }
        }
    }

    /**
     * 关闭文件流
     *
     * @param out 输出流
     */
    public static void close(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                LOGGER.error("[Close file steam error]", e);
            }
        }
    }

    /**
     * 关闭文件流
     *
     * @param in
     */
    public static void close(Reader in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                LOGGER.error("[Close file steam error]", e);
            }
        }
    }

    /**
     * 关闭文件流
     *
     * @param out
     */
    public static void close(Writer out) {
        if (out != null) {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                LOGGER.error("[Close file steam error]", e);
            }
        }
    }

    /**
     * 关闭文件流
     *
     * @param channel FileChannel
     */
    public static void close(FileChannel channel) {
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
                LOGGER.error("[Close file steam error]", e);
            }
        }
    }

    /**
     * 获取文件名的后缀
     *
     * @param fileName
     * @return
     */
    public static String getFileExt(String fileName) {
        if (!fileName.contains(".")) {
            throw new IllegalStateException("The format of fileName is illegal.");
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] getBytes(File file) throws IOException {
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            return getBytes(fis);
        } catch (IOException e) {
            throw e;
        } finally {
            close(fis);
            close(bos);
        }
    }

    /**
     * 获取缓冲流
     *
     * @param fis
     * @return
     * @throws IOException
     */
    public static byte[] getBytes(InputStream fis) throws IOException {
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream(1024 * 512);
            byte[] bts = new byte[1024 * 512];
            int len = fis.read(bts);
            while (len != -1) {
                bos.write(bts, 0, len);
                len = fis.read(bts);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            throw e;
        } finally {
            close(fis);
            close(bos);
        }
    }
}
