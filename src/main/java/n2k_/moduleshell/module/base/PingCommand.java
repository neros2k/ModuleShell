package n2k_.moduleshell.module.base;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.CommandContext;
import n2k_.moduleshell.base.AbstractCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class PingCommand extends AbstractCommand {
    private final static String COMMAND_NAME = "def-ping";
    private final static String COMMAND_DESC = "Default ping command.";

    public PingCommand(AbstractModule module, JDA jda, String prefix) {
        super(module, jda, COMMAND_NAME, COMMAND_DESC, prefix);
    }

    @Override
    protected void onMessageCommand(@NotNull CommandContext ctx, @NotNull MessageReceivedEvent event) {
        event.getMessage().reply("Pong!").queue();
    }

    @Override
    protected void onSlashCommand(CommandContext ctx, @NotNull SlashCommandInteractionEvent event) {
        event.reply("Pong!").queue();
    }
}
