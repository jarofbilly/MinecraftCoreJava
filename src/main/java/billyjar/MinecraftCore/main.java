package billyjar.MinecraftCore;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.Utils;

public class main extends PluginBase {
    @Override
    public void onEnable()
    {
        this.getLogger().info(TextFormat.GREEN + "Plugin Enabled");
    }
    @Override
    public void onDisable()
    {
        this.getLogger().info(TextFormat.RED + "Plugin Disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName().toLowerCase();
        if ("example".equals(cmd)) {
            Player target = sender.getServer().getPlayerExact(sender.getName());
            Item item = new Item(ItemID.COMPASS);
            target.getInventory().setItem(5, item);
            //target.getInventory().addItem(item);
            sender.sendMessage("This is a test");
        }
        return true;
    }
}
