/*
Here are all the methods to be used in other files
*/
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

    /*This method will be called from main method to get the path and print the result to the console*/
    public static void init(String filePath) {
        getTheListOfFiles(filePath);
        printFileInfoToConsole();
    }

    /*returns the list of files and folders from @param path input*/
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

    /*returns the sorted list of files and folders. The sorting is by Size*/
    static class SortBySize implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            if(o1.length() < o2.length()) return -1;
            if (o1.length() > o2.length()) return 1;
            return 0;
        }
    }

    /*returns a json format of the file and folders to be used in API call*/
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

    /*print the result to the console*/
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
}
