package xyz.trixkz.bedwarspractice.menusystem.arena.buttons;

import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.trixkz.bedwarspractice.menusystem.arena.callback.TypeCallback;
import xyz.trixkz.bedwarspractice.utils.Utils;

@AllArgsConstructor
public class ConfirmationButton extends Button {

	private boolean confirm;
	private TypeCallback<Boolean> callback;
	private boolean closeAfterResponse;

	@Override
	public ItemStack getButtonItem(Player player) {
		ItemStack itemStack = new ItemStack(Material.WOOD, 1, this.confirm ? ((byte) 5) : ((byte) 14));
		ItemMeta itemMeta = itemStack.getItemMeta();

		itemMeta.setDisplayName(this.confirm ? Utils.translate("&aConfirm") : Utils.translate("&cCancel"));
		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}

	@Override
	public void clicked(Player player, int i, ClickType clickType, int hb) {
		if (this.confirm) {
			player.playSound(player.getLocation(), Sound.NOTE_PIANO, 20f, 0.1f);
		} else {
			player.playSound(player.getLocation(), Sound.DIG_GRAVEL, 20f, 0.1F);
		}

		if (this.closeAfterResponse) {
			player.closeInventory();
		}

		this.callback.callback(this.confirm);
	}
}
