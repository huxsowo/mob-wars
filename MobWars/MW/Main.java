package MW;

import MW.Kits.KitZombie;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Plugin ourInstance;
    public static Kit[] allKits;

    public static void main(String[] args){
    }

    public static Plugin getInstance() {return ourInstance;}

    @Override
    public void onEnable() {
        ourInstance = this;
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new EventManager(), this);

        allKits = new Kit[]{

                //List of all kits. Be sure to add any new kits to this list so that they appear in game.
                new KitZombie()
        };
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        switch (cmd.getName().toLowerCase()){
            case "kit":
                Inventory kitMenu = Bukkit.createInventory((Player) sender, InventoryType.CHEST);
                for (Kit kit : allKits){
                    ItemStack kitItem = new ItemStack(kit.menuItem,1);
                    ItemMeta meta = kitItem.getItemMeta();
                    meta.setDisplayName(kit.name);
                    kitItem.setItemMeta(meta);
                    kitMenu.addItem(kitItem);
                }
                ((Player) sender).openInventory(kitMenu);
        }
        return true;
    }
}