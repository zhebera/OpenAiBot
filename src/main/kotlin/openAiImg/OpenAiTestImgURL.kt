package openAiImg

import com.aallam.openai.api.BetaOpenAI

@OptIn(BetaOpenAI::class)
class OpenAiTestImgURL(key: String, textMessage: String): OpenAiTestImg(key, textMessage){
    override suspend fun write() = openAi.imageURL(imgCompletionRequest)[0].url
}