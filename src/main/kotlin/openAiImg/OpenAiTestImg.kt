package openAiImg

import com.aallam.openai.api.BetaOpenAI
import common.OpenAiCommon

@OptIn(BetaOpenAI::class)
abstract class OpenAiTestImg(key: String, textMessage: String): OpenAiCommon(key){
    val imgCompletionRequest = OpenAiImage(textMessage).creation
}