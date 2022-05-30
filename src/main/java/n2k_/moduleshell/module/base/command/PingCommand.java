package n2k_.moduleshell.module.base.command;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.AbstractMessageCommand;
import n2k_.moduleshell.base.command.CommandContext;
import n2k_.moduleshell.module.config.ConfigModule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class PingCommand extends AbstractMessageCommand {
    public PingCommand(AbstractModule module, JDA jda, String name, String description, String prefix) {
        super(module, jda, name, description, prefix);
    }

    @Override
    protected void onMessageCommand(CommandContext ctx, @NotNull MessageReceivedEvent event) {
        String message = ConfigModule.getConfig(event.getGuild().getId(), super.getModule().getID())
                .getLocalised("ping_message");
        event.getMessage().reply(message).queue();
    }
}
