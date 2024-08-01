package fr.dawan;

import fr.dawan.listener.BotListener;
import fr.dawan.models.User;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import java.util.Objects;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        User u = new User();
        //User user = new User(27, "Yanis");
        //User namedUser = new User(18, "Yasmine", "ADEKALOM");
        System.out.println(u.age());
        User fluentUser = new User().age(27).prenom("Yanis").nom("ADEKALOM");
        //String token = Objects.requireNonNull(args[0]);
        String token = Objects.toString(args[0], "token");
        JDA jda = startBot(token, new BotListener());
    }

    public static JDA startBot(String token, ListenerAdapter adapter) {
        return JDABuilder.createDefault(token)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.MESSAGE_CONTENT
                )
                .setChunkingFilter(ChunkingFilter.ALL)
                .setBulkDeleteSplittingEnabled(false)
                .addEventListeners(adapter).build();
    }
}
