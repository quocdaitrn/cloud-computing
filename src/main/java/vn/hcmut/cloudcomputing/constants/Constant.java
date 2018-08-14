package vn.hcmut.cloudcomputing.constants;

public class Constant {

    // Replace or verify the region.
    //
    // You must use the same region in your REST API call as you used to obtain your subscription keys.
    // For example, if you obtained your subscription keys from the westus region, replace
    // "westcentralus" in the URI below with "westus".
    //
    // NOTE: Free trial subscription keys are generated in the westcentralus region, so if you are using
    // a free trial subscription key, you should not need to change this region.
    public static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/vision/v1.0/analyze";


    // Text to speech service Uri
    public static final String ttsServiceUri = "https://speech.platform.bing.com/synthesize";

    // Accecss token Uri
    public static final String AccessTokenUri = "https://api.cognitive.microsoft.com/sts/v1.0/issueToken";
}
