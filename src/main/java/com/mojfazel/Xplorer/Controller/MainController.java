/*
This controller gets provides the UI with the list of files and folders of the path the user enters.
*/
package com.mojfazel.Xplorer.Controller;

import com.mojfazel.Xplorer.HelperMethods.Helpers;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class MainController {
    @GetMapping
    public String getFilesToUpdateUI(@RequestParam(name="path", required = false)String path, Model model) {
        Helpers.getTheListOfFiles(path);
        JSONObject files = Helpers.getFilesInfo();
        model.addAttribute("files", files);
        return "index";
    }
}

