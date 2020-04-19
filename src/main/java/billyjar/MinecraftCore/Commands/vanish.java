package billyjar.MinecraftCore.Commands;

import billyjar.MinecraftCore.CommandBase;
import billyjar.MinecraftCore.CoreApi;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

public class vanish extends CommandBase {
    public vanish (CoreApi api){
        super("vanish", api);
    }

    public boolean execute(CommandSender sender, String s, String[] strings) {
        if (!this.testPermission(sender)) {return false;}

        Player player = sender.getServer().getPlayerExact(sender.getName());

        return true;

    }
}
