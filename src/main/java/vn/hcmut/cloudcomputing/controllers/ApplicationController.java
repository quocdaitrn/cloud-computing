package vn.hcmut.cloudcomputing.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.hcmut.cloudcomputing.constants.AudioOutputFormat;
import vn.hcmut.cloudcomputing.constants.Gender;
import vn.hcmut.cloudcomputing.services.ApplicationService;
import vn.hcmut.cloudcomputing.services.StorageService;
import vn.hcmut.cloudcomputing.storage.StorageFileNotFoundException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationController {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    private final StorageService storageService;

    private final String outputFormat = AudioOutputFormat.Riff16Khz16BitMonoPcm;
    private final String deviceLanguage = "en-US";
    private final String genderName = Gender.Female;
    private final String voiceName = "Microsoft Server Speech Text to Speech Voice (en-US, ZiraRUS)";

    @Value("${computerVisionApiKey}")
    private String computerVisionApiKey;

    @Value("${textToSpeechApiKey}")
    private String textToSpeechApiKey;

    @Autowired
    ApplicationService service;

    @Autowired
    public ApplicationController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "uploadForm";
    }

    @PostMapping(value = "/process", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] extractVoiceDescription(@RequestParam("file") MultipartFile file) {

        String tmpUrl = "https://upload.wikimedia.org/wikipedia/commons/1/12/Broadway_and_Times_Square_by_night.jpg";

        byte[] bytes = new byte[0];

        try {
            String imageUrl = storageService.store(file);

            byte[] audioBuffer = service.extractVoiceDescription(tmpUrl, outputFormat, deviceLanguage, genderName,
                    voiceName, computerVisionApiKey, textToSpeechApiKey);

            return audioBuffer;

        } catch (Exception e) {
            return bytes;
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
