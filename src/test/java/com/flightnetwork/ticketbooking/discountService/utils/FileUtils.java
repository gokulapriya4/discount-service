package com.flightnetwork.ticketbooking.discountService.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static File getFileFromTestResources(String relativePath) {
        try {
            return new File(FileUtils.class.getResource(String.format("/%s", relativePath)).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(String.format("Encountered error while fetching file path for file resource %s", relativePath), e);
        }
    }
}
