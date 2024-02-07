package com.example.laba_3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class CreateJar{
    public static void main(String[] args) {
        String sourceDirectory = "C:\\Users\\Nastya\\IdeaProjects\\laba_3";
        String jarFileName = "D:/papochka/output.jar";

        try {
            FileOutputStream fos = new FileOutputStream(jarFileName);
            JarOutputStream jos = new JarOutputStream(fos);

            // Рекурсивно добавляем все файлы и директории в JAR-файл
            addFilesToJar(sourceDirectory, "", jos);

            jos.close();
            fos.close();

            System.out.println("JAR-файл успешно создан.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFilesToJar(String sourceDirectory, String relativePath, JarOutputStream jos) throws IOException {
        java.io.File file = new java.io.File(sourceDirectory + "/" + relativePath);
        String[] fileList = file.list();

        for (String fileName : fileList) {
            java.io.File f = new java.io.File(sourceDirectory + "/" + relativePath + "/" + fileName);

            if (f.isDirectory()) {
                addFilesToJar(sourceDirectory, relativePath + "/" + fileName, jos);
                continue;
            }

            JarEntry jarEntry = new JarEntry(relativePath + "/" + fileName);
            jos.putNextEntry(jarEntry);

            java.io.FileInputStream fis = new java.io.FileInputStream(f);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                jos.write(buffer, 0, bytesRead);
            }

            fis.close();
            jos.closeEntry();
        }
    }
}