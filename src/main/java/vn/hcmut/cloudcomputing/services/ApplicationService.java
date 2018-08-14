package vn.hcmut.cloudcomputing.services;

public interface ApplicationService {

    byte[] extractVoiceDescription(String imageUrl, String outputFormat, String locale,
                      String genderName, String voiceName, String computerVisionApiKey, String textToSpeechApiKey) throws Exception;
}
