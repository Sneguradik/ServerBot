import MyPackage.Router
import MyPackage.Routes.BaZaRoute
import MyPackage.Routes.GetIdRoute
import MyPackage.Routes.SayHiRoute
import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

suspend fun main(args: Array<String>) {
    val secret = "MTE4NjczODU2MTE3MzY5MjUxNg.GH5P8p.TcpApl6Rz5JT6EVhPKVfbwTrnIDFOdk486V_Rs"
    val kord = Kord(secret)
    val router = Router(kord)
    router.AddRoute(SayHiRoute())
    router.AddRoute(GetIdRoute())
    router.AddRoute(BaZaRoute())
    router.Start()

    kord.login {
        // we need to specify this to receive the content of messages
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent
    }
}

