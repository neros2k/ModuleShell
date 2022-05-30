package n2k_.moduleshell.module.msr.command;
import n2k_.moduleshell.ModuleShell;
import n2k_.moduleshell.base.AbstractModule;
import n2k_.moduleshell.base.command.AbstractMessageCommand;
import n2k_.moduleshell.base.command.CommandContext;
import n2k_.moduleshell.ModuleEnum;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class InstallCommand extends AbstractMessageCommand {
    public InstallCommand(AbstractModule module, String name, String description, String prefix) {
        super(module, module.getJDA(), name, description, prefix);
    }

    @Override
    protected void onMessageCommand(@NotNull CommandContext ctx, @NotNull MessageReceivedEvent event) {
        Message message = event.getMessage();
        String[] args = ctx.getArgs();
        if(args.length == 1) {
            event.getMessage().reply("Usage: `" + super.getPrefix() + super.getName() + " <module_id>`").queue();
            return;
        }
        if(!ModuleEnum.getModules().containsKey(args[1])) {
            event.getMessage().reply("Module `" + args[1] + "` not found.").queue();
            return;
        }
        message.reply("Installing module `" + args[1] + "`...").queue(success -> {
            if(ModuleShell.installModule(event.getGuild().getId(), args[1])) {
                success.editMessage("Module `" + args[1] + "` successfully installed.").queue();
            } else {
                success.editMessage("Module `" + args[1] + "` is already installed.").queue();
            }
        });
    }
}
