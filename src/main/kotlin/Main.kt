import MyPackage.SayHi
import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent


suspend fun main(args: Array<String>) {
    val secret = "MTE4NjczODU2MTE3MzY5MjUxNg.Gr5U19.mSkYiTC6sdsMZP2MF7p4zwbN2VK37vwrkKq898"
    val kord = Kord(secret)
    kord.on<MessageCreateEvent> {

        if (message.author?.isBot != false) return@on

        if (message.content != "!ping") return@on

        message.channel.createMessage("pong!")
    }

    kord.on<MessageCreateEvent> {

        if (message.author?.isBot != false) return@on

        if (message.content != "!хохол") return@on
        for(i in 0..100){message.channel.createMessage("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ Смерть Хохлам!!!!!!!!!!!!!!!!!!!!!!!!!")}
    }

    kord.on<MessageCreateEvent> {

        if (message.author?.isBot != false) return@on

        if (message.content != "!gg") return@on

        message.channel.createMessage("good")
    }


    kord.login {
        // we need to specify this to receive the content of messages
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent
    }
}

