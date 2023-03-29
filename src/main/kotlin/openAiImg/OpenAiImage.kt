package openAiImg

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.image.ImageCreation
import com.aallam.openai.api.image.ImageSize

@OptIn(BetaOpenAI::class)
class OpenAiImage (textMessage: String){
    val creation = ImageCreation(
        prompt = textMessage,
        n = 1,
        size = ImageSize.is1024x1024
    )
}