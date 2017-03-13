package cf.brforgers.mods.industrialexpansion.manager;

import cf.brforgers.mods.industrialexpansion.helper.ConfigHandler;
import cofh.thermalexpansion.init.TEFlorbs;
import cofh.thermalexpansion.item.ItemFrame;
import cofh.thermalexpansion.util.crafting.CompactorManager;
import cofh.thermalfoundation.block.BlockGlass;
import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.item.ItemMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeManager {
    public static void init() {
        ItemStack glowflorb = TEFlorbs.florb;
        if(glowflorb.getTagCompound() == null){
            glowflorb.setTagCompound(new NBTTagCompound());
        }
        glowflorb.getTagCompound().setString("Fluid","glowstone");
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.CoalBall,1),
                "AAA","ABA","AAA",
                'A', ItemMaterial.dustCoal,
                'B', Items.FLINT);
        CompactorManager.addRecipe(ConfigHandler.energyCompactCoalBall, new ItemStack(ItemManager.CoalBall),new ItemStack(ItemManager.CompactCoalBall), CompactorManager.Mode.PRESS);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.CoalChunk,1),
                "AAA","ABA","AAA",
                'A', ItemManager.CompactCoalBall,
                'B', Blocks.OBSIDIAN);
        CompactorManager.addRecipe(ConfigHandler.energyDiamond, new ItemStack(ItemManager.CoalChunk),new ItemStack(Items.DIAMOND), CompactorManager.Mode.PRESS);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemHelmetQuantum,1),
                " A ","BCB","DED",
                'A', Items.DIAMOND_HELMET,
                'B', ItemMaterial.plateIridium,
                'C', BlockStorageAlloy.blockEnderium,
                'D', ItemMaterial.gearLumium,
                'E', BlockGlass.glassIridium);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemPlateQuantum,1),
                "ABA","CDC","CAC",
                'A', ItemMaterial.ingotEnderium,
                'B', Items.DIAMOND_CHESTPLATE,
                'C', ItemMaterial.plateIridium,
                'D', BlockStorageAlloy.blockEnderium);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemLegsQuantum,1),
                "ABA","CDC","E E",
                'A', ItemFrame.frameMachine,
                'B', BlockStorageAlloy.blockEnderium,
                'C', ItemMaterial.plateIridium,
                'D', Items.DIAMOND_LEGGINGS,
                'E', glowflorb);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemBootsQuantum,1),
                "ABA","CDC","   ",
                'A', ItemMaterial.plateIridium,
                'B', Items.DIAMOND_BOOTS,
                'C', ForgeRegistries.ITEMS.getValue(new ResourceLocation("thermalfoundation","armor.boots_tin")),
                'D', BlockStorageAlloy.blockEnderium);

    }
}