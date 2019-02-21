package com.tancy.zip;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author tancy
 * @description 实现zip文件压缩工具
 * @date 2019/2/21 14:33
 **/
public class ZipUtil {

    private static final int defaultCapacity=1<<7;
    private File sourceFile;
    private File targetFile;

    private HashMap<String,List<Path>> zipFile=new HashMap<>(defaultCapacity);

    public ZipUtil() {
    }

    public ZipUtil(String sourceFile, String targetFile) {
        this.sourceFile = Paths.get(sourceFile).toFile();
        this.targetFile = Paths.get(targetFile).toFile();
    }

    public void doZip(){
        try {
            Files.walkFileTree(sourceFile.toPath(),new ZipFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
        createZip();
    }

    public class ZipFileVisitor extends SimpleFileVisitor<Path>{

        private String preName=null;
        private List<Path> paths=null;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String zipName= file.getParent().getParent().relativize(file.getParent()).toString();
            if (!zipName.equals(preName)){
                paths=new ArrayList<>();
                zipFile.put(zipName,paths);
            }
            paths.add(file);
            preName=zipName;
            return super.visitFile(file, attrs);
        }
    }

    private Path zipDiretory(){
        try {
            Path newpath= Files.createDirectories(targetFile.toPath());
            return newpath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Path zipFilename(String zipName){
        Path path= zipDiretory();
        StringBuffer sb=new StringBuffer(path.toString());
        sb.append("/");
        sb.append(zipName);
        sb.append(".zip");
        try {
            return new File(sb.toString()).toPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void createZip(){
        Set set=zipFile.entrySet();
        Iterator itr=set.iterator();
        while (itr.hasNext()){
            Map.Entry entry= (Map.Entry) itr.next();
            OutputStream os= null;
            ZipOutputStream zos=null;
            try {
                os = Files.newOutputStream(zipFilename(entry.getKey().toString()), StandardOpenOption.CREATE);
                zos=new ZipOutputStream(os);

                List<Path> fileList= (List<Path>) entry.getValue();
                for (Path path : fileList) {
                    InputStream is = null;
                    byte[] buf = new byte[1024];
                    try {
                        zos.putNextEntry(new ZipEntry(path.toFile().getName()));
                        is = Files.newInputStream(path, StandardOpenOption.READ);
                        int len;
                        while ((len = is.read(buf)) > 0) {
                            zos.write(buf, 0, len);
                            zos.flush();
                        }
                        zos.closeEntry();
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                System.out.println("close zos");
                try {
                    if (zos != null) {
                        zos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
