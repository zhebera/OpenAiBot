package common

import com.aallam.openai.client.OpenAI

abstract class OpenAiCommon(key: String){
    val openAi = OpenAI(key)
    abstract suspend fun write() : String?
}