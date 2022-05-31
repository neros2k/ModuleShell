package n2k_.moduleshell.module.config.command;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.AbstractMessageCommand;
import n2k_.moduleshell.base.command.CommandContext;
import n2k_.moduleshell.module.config.ConfigModule;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
public class SetValue extends AbstractMessageCommand {
    public SetValue(AbstractModule module, String name, String description, String prefix) {
        super(module, module.getJDA(), name, description, prefix);
    }

    @Override
    protected void onMessageCommand(CommandContext ctx, MessageReceivedEvent event) {
        Guild guild = event.getGuild();
        String id = guild.getId();
        Message message = event.getMessage();
        String[] args = ctx.getArgs();
        if(args.length < 4) {
            message.reply("Usage: "+super.getPrefix(id)+super.getName(id)).queue();
            return;
        }
        ConfigModule.getConfig(id, args[1]).getValues().put(args[2], args[3]);
        message.reply("`" + args[1] + "` : `" + args[2] + "` = `" + args[3] + "`").queue();
    }
}
