package billyjar.MinecraftCore;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;


public class CorePluginManager extends PluginBase{ //extends pluginbase allows for the use of plugin
    public static CorePluginManager plugin;

    private CoreApi api; //this is an api, we have to make it as an api

    @Override
    public void onEnable(){
        plugin = this;
        this.api = new CoreApi(this); // set the api to an instance of the CoreApi
        CoreCommandManager.registerAll(this.api); //will load all the commands
        this.getServer().getPluginManager().registerEvents(new events(), this);
        this.getLogger().info(TextFormat.GREEN + "Plugin Enabled");
    }
    @Override
    public void onDisable()
    {
        this.getLogger().info(TextFormat.RED + "Plugin Disabled");
    }
}

