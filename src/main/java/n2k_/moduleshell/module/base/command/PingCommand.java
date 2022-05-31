package n2k_.moduleshell.module.base.command;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.AbstractMessageCommand;
import n2k_.moduleshell.base.command.CommandContext;
import n2k_.moduleshell.module.config.ConfigModule;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class PingCommand extends AbstractMessageCommand {
    private final static String DEFAULT_NAME = "ping";
    private final static String DEFAULT_DESCRIPTION = "Ping command.";

    public PingCommand(AbstractModule module, String prefix) {
        super(module, module.getJDA(), PingCommand.DEFAULT_NAME, PingCommand.DEFAULT_DESCRIPTION, prefix);
    }

    @Override
    protected void onMessageCommand(CommandContext ctx, @NotNull MessageReceivedEvent event) {
        String message = ConfigModule.getConfig(event.getGuild().getId(), super.getModule().getID())
                .getLocalised(super.getName(event.getGuild().getId())+".message");
        event.getMessage().reply(message).queue();
    }

    public static String getDefaultName() {
        return PingCommand.DEFAULT_NAME;
    }

    public static String getDefaultDescription() {
        return PingCommand.DEFAULT_DESCRIPTION;
    }
}
