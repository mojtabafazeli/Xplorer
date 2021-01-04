/*This is a model to store the name, size and last modified info of each file and folder listed in the result*/
package com.mojfazel.Xplorer.Model;

import java.util.Date;

public class SimpleFile {
    private String name;
    private long size;
    private Date lastModDate;

    public SimpleFile (String name, long size, Date lastModDate) {
        this.name = name;
        this.size = size;
        this.lastModDate = lastModDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
    }
    //    public String[] getFileInfo() {
//        String[] fileInfo = new String[]{this.name, String.valueOf(this.size), String.valueOf(this.lastModDate)};
//        return fileInfo;
//    }

}
