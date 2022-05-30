package n2k_.moduleshell.module.base;
import n2k_.moduleshell.ModuleShell;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.AbstractMessageCommand;
import n2k_.moduleshell.base.command.CommandContext;
import n2k_.moduleshell.module.ModuleEnum;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class InstallCommand extends AbstractMessageCommand {
    public InstallCommand(AbstractModule module, String prefix) {
        super(module, module.getJDA(), "def-install", "Install module command.", prefix);
    }

    @Override
    protected void onMessageCommand(@NotNull CommandContext ctx, @NotNull MessageReceivedEvent event) {
        Message message = event.getMessage();
        String[] args = ctx.getArgs();
        if(args.length < 1) {
            event.getMessage().reply("**Usage:** `" + super.getPrefix() + super.getName()).queue();
            return;
        }
        if(!ModuleEnum.getModules().containsKey(args[1])) {
            event.getMessage().reply("Module `" + args[1] + "` not found.").queue();
            return;
        }
        boolean success = ModuleShell.enableModule(event.getGuild().getId(), args[1]);
        if(success) {
            message.reply("Module `" + args[1] + "` successfully installed.").queue();
        } else {
            message.reply("Module `" + args[1] + "` is already installed.").queue();
        }
    }
}
