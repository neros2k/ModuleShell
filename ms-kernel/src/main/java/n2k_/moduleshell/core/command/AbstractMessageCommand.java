package n2k_.moduleshell.core.command;
import n2k_.moduleshell.core.module.AbstractModule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public abstract class AbstractMessageCommand extends AbstractConfigCommand {
    public AbstractMessageCommand(AbstractModule module, JDA jda, String name, String description, String prefix) {
        super(module, jda, name, description, prefix);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String guildId = event.getGuild().getId();
        String message = event.getMessage().getContentDisplay();
        String[] split = message.split(" ");
        if(split[0].equals(super.getConfigPrefix(guildId)+super.getConfigName(guildId))) {
            CommandContext ctx = new CommandContext(super.getJDA(), message, event.getMember(), event.getChannel());
            if(super.getModule().isValid(event.getGuild().getId())) {
                this.onMessageCommand(ctx, event);
            } else {
                super.getModule().onInvalidCall(ctx);
            }
        }
    }

    protected abstract void onMessageCommand(CommandContext ctx, MessageReceivedEvent event);
}
