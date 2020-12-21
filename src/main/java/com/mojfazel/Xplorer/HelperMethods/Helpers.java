package com.mojfazel.Xplorer.HelperMethods;

import com.mojfazel.Xplorer.Model.SimpleFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.*;

public class Helpers {
    private static List<File> files;

    private static int numOfFiles;
    private static long totalSize;

    public static void init(String filePath) {
        getTheListOfFiles(filePath);
        printFileInfoToConsole();
    }

    public static List<File> getTheListOfFiles(String path) {
        files = Arrays.asList();
        System.out.println(path);
        if(path!=null && path.equals("C:")) {path = "C:\\";}
        try {
            File f = new File(path);
            files = Arrays.asList(f.listFiles());
            Collections.sort(files, new SortBySize());
        } catch (Exception e) {
            System.out.println("This is not a valid path");
        }
        return files;
    }

    static class SortBySize implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            if(o1.length() < o2.length()) return -1;
            if (o1.length() > o2.length()) return 1;
            return 0;
        }
    }

    public static JSONObject getFilesInfo() {
       JSONObject finalInfoInJason = new JSONObject();
       JSONArray filesInfoInJason = new JSONArray();
        numOfFiles = 0;
        totalSize = 0;

        for(File item: files) {
            SimpleFile sf = new SimpleFile(item.getName(), item.length(), new Date(item.lastModified()));
            String[] fileInfo = new String[]{sf.getName(), String.valueOf(sf.getSize()), String.valueOf(sf.getLastModDate())};
           filesInfoInJason.add(fileInfo);
            numOfFiles++;
            totalSize += item.length();
        }
        finalInfoInJason.put("files", filesInfoInJason);
        finalInfoInJason.put("totalNumber", numOfFiles);
        finalInfoInJason.put("totalSize", totalSize);
        return finalInfoInJason;
    }

    private static void printFileInfoToConsole() {
        numOfFiles = 0;
        totalSize = 0;
        if (files != null && !files.isEmpty()) {
            for (File item : files) {
                System.out.format("Name: %s \n", item.getName());
                System.out.println("Last Modified: " + new Date(item.lastModified()));
                System.out.format("Size: %d bytes \n", item.length());
                System.out.println("--------------------------------------------------------------");
                numOfFiles++;
                totalSize += item.length();
            }
            System.out.format("Total number of files: %d \n", numOfFiles);
            System.out.format("Total size: %d bytes \n", totalSize);
        }
    }

    //    private static String getThePath() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the path (or type 'exit' to exit");
//        return scanner.nextLine();
//    }

}
