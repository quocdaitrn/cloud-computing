package vn.hcmut.cloudcomputing.services;

import org.springframework.stereotype.Service;
import vn.hcmut.cloudcomputing.helpers.Helper;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public byte[] extractVoiceDescription(String imageUrl, String outputFormat, String locale, String genderName,
                                          String voiceName, String computerVisionApiKey, String textToSpeechApiKey) throws Exception {

        String decription = Helper.analyze(imageUrl, computerVisionApiKey);

        return Helper.synthesize(decription, outputFormat, locale, genderName, voiceName, textToSpeechApiKey);
    }
}
