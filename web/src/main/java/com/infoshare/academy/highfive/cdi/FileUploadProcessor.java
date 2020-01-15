package com.infoshare.academy.highfive.cdi;

import com.infoshare.academy.highfive.exception.JsonFileNotFound;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequestScoped
public class FileUploadProcessor {
//    private String SETTINGS_FILE = "settings.properties";
//    private String FILE_LINE = "Upload.Path.Images";

//    public String getUploadImageFilesPath() throws IOException {
//
//        Properties settings = new Properties();
//        settings.load(Thread.currentThread().getContextClassLoader().getResource(SETTINGS_FILE).openStream());
//
//        return settings.getProperty(FILE_LINE);
//
//    }


    public InputStream uploadJsonFile(Part filePart) throws IOException, JsonFileNotFound {

        //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

//        if (fileName == null || fileName.isEmpty()) {
//            throw new JsonFileNotFound("No JSON found!");
//        }

//

        InputStream fileContent = filePart.getInputStream();
        // old way and bytes an sonone OutputStream os = new FileOutputStream(file);

        //Files.copy(fileContent, file.toPath());

        fileContent.close();

        return fileContent;
    }
}
