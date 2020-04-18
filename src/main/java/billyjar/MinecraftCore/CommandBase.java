package billyjar.MinecraftCore;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public abstract class CommandBase extends Command {

    protected CoreApi api;

    public CommandBase(String name, CoreApi api) {
        super(name);
        this.setPermission("MinecraftCore." + name);
        this.api = api;
    }

    protected CoreApi getApi(){
        return api;
    }

    protected void sendUser(CommandSender sender, String name) {
        sender.sendMessage(name+" has been used!");
    }

}
