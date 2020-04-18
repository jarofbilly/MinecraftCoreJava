package billyjar.MinecraftCore.Commands;

import billyjar.MinecraftCore.CommandBase;
import billyjar.MinecraftCore.CoreApi;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;


public class example extends CommandBase{

    public example(CoreApi api){
        super("example", api);
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {return false;} //if they have the permision to use this

        Player target = sender.getServer().getPlayerExact(sender.getName());

        Item item = new Item(ItemID.COMPASS);
        target.getInventory().setItem(4, item);
        target.sendMessage("Given compass to " + target.getName());
        showGmf(target);

        return true;
    }

    public void showGmf(Player p) {
        FormWindowSimple gui = new FormWindowSimple("Gamemode UI", "Change your game mode quickly and simply");

        gui.addButton(new ElementButton("Adventure"));
        gui.addButton(new ElementButton("Creative"));
        gui.addButton(new ElementButton("Survival"));
        gui.addButton(new ElementButton("Spectator"));


        p.showFormWindow(gui);
    }
}


