package openAiChat

import com.aallam.openai.api.BetaOpenAI
import common.OpenAiCommon

@OptIn(BetaOpenAI::class)
class OpenAiTestChat(key: String, textMessage: String): OpenAiCommon(key){
    val response = OpenAiChatCompletionRequest(textMessage).chatCompletionRequest
    override suspend fun write() = openAi.chatCompletion(response).choices[0].message?.content
}