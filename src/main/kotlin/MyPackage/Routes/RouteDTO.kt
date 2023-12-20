package MyPackage.Routes
import dev.kord.rest.builder.interaction.integer

import dev.kord.core.behavior.interaction.response.respond

import dev.kord.core.entity.interaction.GuildChatInputCommandInteraction
import dev.kord.rest.builder.component.ActionRowBuilder

import dev.kord.rest.builder.component.MessageComponentBuilder
import dev.kord.rest.builder.interaction.ChatInputCreateBuilder
import dev.kord.rest.builder.interaction.role

interface IRouteDTO{
    val Name:String
    val Description:String
    val builder:ChatInputCreateBuilder.()->Unit
    suspend fun callback(interaction: GuildChatInputCommandInteraction)
}

class SayHiRoute:IRouteDTO{
    override val Name:String = "greetme"
    override val Description: String = "Greetings you"
    override val builder: ChatInputCreateBuilder.() -> Unit = {}
    override suspend fun callback(interaction: GuildChatInputCommandInteraction){
        val user = interaction.user
        val resp = interaction.deferEphemeralResponse()
        resp.respond { content="Hi, ${user.nickname?:"Anonymus"}, Command: !"  }
    }
}

class GetIdRoute:IRouteDTO{
    override val Name:String = "getid"
    override val Description: String = "Gives you Id"
    override val builder: ChatInputCreateBuilder.() -> Unit = {}
    override suspend fun callback(interaction: GuildChatInputCommandInteraction) {
        val id = interaction.user.id.toString()
        val resp = interaction.deferEphemeralResponse()
        val v = ActionRowBuilder()

        v.linkButton("https://google.com") {
            label = "google"
        }
        val ls = mutableListOf<MessageComponentBuilder>(v)
        resp.respond { content = "M&M's";components = ls }
    }
}


class BaZaRoute:IRouteDTO{
    override val Name:String = "bazzza"
    override val Description: String = "Gives you bazzza"
    override val builder: ChatInputCreateBuilder.() -> Unit = {
        integer("count", "This option represents number of messages (<100)"){
            required = true
        }
        role("role", "This option represents the audience"){
            required = true
        }
    }
    override suspend fun callback(interaction: GuildChatInputCommandInteraction) {

        val resp = interaction.deferEphemeralResponse()
        var count = interaction.command.integers["count"]!!
        val name = interaction.user.nickname?:"Anonymus"
        val role = interaction.command.roles["role"]!!
        resp.respond { content = "BAZA"}
        if (count>100) count = 100
        else if (count<1) count = 1

        for (i in 1..count){ interaction.channel.createMessage("ZZZZZZZZZZZZZZZZZ ${name} желает СМЕРТИ ${role.name.uppercase()}!!!!!! #${i} ZZZZZZZZZZZZZZZZZZZZ")}


    }
}