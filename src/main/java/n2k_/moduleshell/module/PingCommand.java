package n2k_.moduleshell.module;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.CommandContext;
import n2k_.moduleshell.base.CommandListener;
import net.dv8tion.jda.api.JDA;
import org.jetbrains.annotations.NotNull;
public class PingCommand extends CommandListener {
    private final static String COMMAND_NAME = "def-ping";
    private final static String COMMAND_DESC = "Default ping command.";

    public PingCommand(AbstractModule module, JDA jda) {
        super(module, jda, COMMAND_NAME, COMMAND_DESC);
    }

    @Override
    protected void onCommand(@NotNull CommandContext ctx) {
        ctx.getChannel().sendMessage("Pong!").queue();
    }

    @Override
    protected boolean isValid(String id) {
        return true;
    }
}
