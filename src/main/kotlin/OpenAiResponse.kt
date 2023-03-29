import com.google.gson.annotations.SerializedName

data class OpenAiResponse(
    val id: String,
    @SerializedName("object") val obj: String,
    val created: Int,
    val model: String,
    val usage: Usage,
    val choices: List<Choices>
)

data class Usage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)

data class Choices(
    val message: Message,
    val finish_reason: String,
    val index: Int
)

data class Message(
    val role: String,
    val content: String
)