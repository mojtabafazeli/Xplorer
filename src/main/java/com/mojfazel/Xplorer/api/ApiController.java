package com.mojfazel.Xplorer.api;

import com.mojfazel.Xplorer.HelperMethods.Helpers;
import com.mojfazel.Xplorer.Model.SimpleFile;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static List<SimpleFile> files = new ArrayList<>();

    @GetMapping
    public JSONObject getFiles(@RequestParam(name="path", required = false)String path) {
        Helpers.getTheListOfFiles(path);
        return Helpers.getFilesInfo();
    }

}
