package openAiImg

import com.aallam.openai.api.BetaOpenAI

@OptIn(BetaOpenAI::class)
class OpenAiTestImgJSON(key: String, textMessage: String): OpenAiTestImg(key,textMessage){
    override suspend fun write() = ConvertRequestToFile(openAi.imageJSON(imgCompletionRequest)[0].b64JSON).convertBs64ToFile()
}