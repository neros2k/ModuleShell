package n2k_.moduleshell.module.defaultmodule;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.CommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
public class PingCommand extends CommandListener {
    private final static String COMMAND_NAME = "def-ping";
    private final static String COMMAND_DESC = "Default ping command.";

    public PingCommand(AbstractModule module, JDA jda) {
        super(module, jda, COMMAND_NAME, COMMAND_DESC);
    }

    @Override
    protected void onCommand(String command, Member author, MessageChannel channel) {
        channel.sendMessage("Pong!").queue();
    }
}
