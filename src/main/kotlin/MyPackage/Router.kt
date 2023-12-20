package MyPackage

import MyPackage.Routes.IRouteDTO
import dev.kord.common.entity.ApplicationCommandType
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent
import dev.kord.core.on

class Router(private val kord:Kord) {
    private val routes = mutableMapOf<String, IRouteDTO>()
    suspend fun Start(){
        kord.on<GuildChatInputCommandInteractionCreateEvent>{
            val command = interaction.command.rootName
            if (command in routes.keys) routes[command]!!.callback(interaction)
        }
    }
    suspend fun AddRoute(route:IRouteDTO){
        kord.createGuildChatInputCommand(Snowflake(1186004554525986867),name = route.Name, description = route.Description, builder = route.builder)
        routes[route.Name] = route
    }


}