package com.whammich.sstow.utils;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.whammich.sstow.SSTheOldWays;
import com.whammich.sstow.block.BlockCage;
import com.whammich.sstow.block.BlockForge;
import com.whammich.sstow.block.BlockPetrified;
import com.whammich.sstow.block.BlockPetrified2;
import com.whammich.sstow.block.BlockPlankPetrified;
import com.whammich.sstow.block.BlockSoulium;
import com.whammich.sstow.block.BlockXenolith;
import com.whammich.sstow.enchantment.EnchantmentSoulStealer;
import com.whammich.sstow.guihandler.GuiHandler;
import com.whammich.sstow.item.ItemClubPetr;
import com.whammich.sstow.item.ItemClubIron;
import com.whammich.sstow.item.ItemClubSoul;
import com.whammich.sstow.item.ItemClubXogu;
import com.whammich.sstow.item.ItemClubDeco;
import com.whammich.sstow.item.ItemMacuPetr;
import com.whammich.sstow.item.ItemMacuIron;
import com.whammich.sstow.item.ItemMacuSoul;
import com.whammich.sstow.item.ItemMacuXogu;
import com.whammich.sstow.item.ItemMacuDeco;
import com.whammich.sstow.item.ItemAxeSoul;
import com.whammich.sstow.item.ItemHoeSoul;
import com.whammich.sstow.item.ItemMaterials;
import com.whammich.sstow.item.ItemModules;
import com.whammich.sstow.item.ItemPickaxeSoul;
import com.whammich.sstow.item.ItemShardSoul;
import com.whammich.sstow.item.ItemSpadeSoul;
import com.whammich.sstow.item.ItemSwordSoul;
import com.whammich.sstow.item.ItemfixedAchievement;
import com.whammich.sstow.item.blocks.ItemBlockForge;
import com.whammich.sstow.item.blocks.ItemBlockPetrified;
import com.whammich.sstow.item.blocks.ItemBlockPetrified2;
import com.whammich.sstow.item.blocks.ItemBlockPlankPetrified;
import com.whammich.sstow.item.blocks.ItemBlockXenolith;
import com.whammich.sstow.tileentity.TileEntityCage;
import com.whammich.sstow.tileentity.TileEntityForge;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Register {
	// Tool material for the soul tools/sword
	public static ToolMaterial SOULIUM = EnumHelper.addToolMaterial("SOULIUM", 3, 3122, 12.0F, 6F, 30);
	public static ToolMaterial MACU1 = EnumHelper.addToolMaterial("MACU1", 3, 10, 12.0F, 5F, 0);
	public static ToolMaterial MACU2 = EnumHelper.addToolMaterial("MACU2", 3, 20, 12.0F, 6F, 0);
	public static ToolMaterial MACU3 = EnumHelper.addToolMaterial("MACU3", 3, 40, 12.0F, 7F, 0);

	// Setting up the enchantment details from the config
	public static Enchantment SOUL_STEALER = new EnchantmentSoulStealer(Config.ENCHANT_ID, Config.ENCHANT_WEIGHT);

	// Set the creative tab
	public static SoulShardTab CREATIVE_TAB = new SoulShardTab();

	// Set up the mod items
	public static Item ItemModules = new ItemModules();
	public static Item ItemMaterials = new ItemMaterials();
	public static Item ItemFixedDummy = new ItemfixedAchievement();
	public static Item ItemShardSoul = new ItemShardSoul();
	public static Item ItemClubDeco = new ItemClubDeco(ToolMaterial.WOOD);
	public static Item ItemClubPetr = new ItemClubPetr(ToolMaterial.STONE);
	public static Item ItemClubIron = new ItemClubIron(ToolMaterial.IRON);
	public static Item ItemClubSoul = new ItemClubSoul(SOULIUM);
	public static Item ItemClubXogu = new ItemClubXogu(SOULIUM);
	public static Item ItemMacuDeco = new ItemMacuDeco(ToolMaterial.WOOD);
	public static Item ItemMacuPetr = new ItemMacuPetr(MACU1);
	public static Item ItemMacuIron = new ItemMacuIron(MACU2);
	public static Item ItemMacuSoul = new ItemMacuSoul(MACU3);
	public static Item ItemMacuXogu = new ItemMacuXogu(MACU3);
	public static Item ItemSwordSoul = new ItemSwordSoul(SOULIUM);
	public static Item ItemPickaxeSoul = new ItemPickaxeSoul(SOULIUM);
	public static Item ItemAxeSoul = new ItemAxeSoul(SOULIUM);
	public static Item ItemHoeSoul = new ItemHoeSoul(SOULIUM);
	public static Item ItemSpadeSoul = new ItemSpadeSoul(SOULIUM);

	// Set up the mod blocks
	public static Block BlockCage = new BlockCage();
	public static Block BlockForge = new BlockForge(false).setCreativeTab(CREATIVE_TAB);
	public static Block BlockForgeActive = new BlockForge(true).setBlockName("sstow.forge_block_active");
	public static Block BlockSoulium = new BlockSoulium();
	
	public static Block BlockXenolith = new BlockXenolith();
	public static Block BlockPetrified = new BlockPetrified();
    public static Block BlockPetrified2 = new BlockPetrified2();
    public static Block BlockPetrifiedPlanks = new BlockPlankPetrified();
    
	public static void registerObjs() {
		NetworkRegistry.INSTANCE.registerGuiHandler(SSTheOldWays.modInstance, new GuiHandler());

		registerItems();
		registerBlocks();
		registerOreDictEntries();
		registerTileEntities();
		registerRecipes();

	}

	private static void registerItems() {

		GameRegistry.registerItem(ItemModules, "ItemModulesSoul");
		GameRegistry.registerItem(ItemMaterials, "ItemMaterialsSoul");
		GameRegistry.registerItem(ItemClubPetr, "ItemClubPetr");
		GameRegistry.registerItem(ItemClubIron, "ItemClubIron");
		GameRegistry.registerItem(ItemClubSoul, "ItemClubSoul");
		GameRegistry.registerItem(ItemClubXogu, "ItemClubXogu");
		GameRegistry.registerItem(ItemClubDeco, "ItemClubDeco");
		GameRegistry.registerItem(ItemMacuPetr, "ItemMacuPetr");
		GameRegistry.registerItem(ItemMacuIron, "ItemMacuIron");
		GameRegistry.registerItem(ItemMacuSoul, "ItemMacuSoul");
		GameRegistry.registerItem(ItemMacuXogu, "ItemMacuXogu");
		GameRegistry.registerItem(ItemMacuDeco, "ItemMacuDeco");
		GameRegistry.registerItem(ItemSwordSoul, "ItemSwordSoul");
		GameRegistry.registerItem(ItemPickaxeSoul, "ItemPickaxeSoul");
		GameRegistry.registerItem(ItemAxeSoul, "ItemAxeSoul");
		GameRegistry.registerItem(ItemHoeSoul, "ItemHoeSoul");
		GameRegistry.registerItem(ItemSpadeSoul, "ItemSpadeSoul");
		GameRegistry.registerItem(ItemShardSoul, "ItemShardSoul");
		
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(BlockForge, ItemBlockForge.class, "BlockForge");
		GameRegistry.registerBlock(BlockForgeActive, BlockForgeActive.getUnlocalizedName());
		GameRegistry.registerBlock(BlockSoulium, "sstow_soulium_block");
		GameRegistry.registerBlock(BlockCage, "sstow_soul_cage");
		GameRegistry.registerBlock(BlockXenolith, ItemBlockXenolith.class, "BlockXenolith");
		GameRegistry.registerBlock(BlockPetrified, ItemBlockPetrified.class, "BlockPetrifiedLog");
		GameRegistry.registerBlock(BlockPetrified2, ItemBlockPetrified2.class, "BlockPetrifiedLog2");
		GameRegistry.registerBlock(BlockPetrifiedPlanks, ItemBlockPlankPetrified.class, "BlockPetrifiedPlanks");
	}

	private static void registerOreDictEntries() {
		OreDictionary.registerOre("nuggetIron", new ItemStack(ItemMaterials, 1, 0));
		OreDictionary.registerOre("nuggetSoulium", new ItemStack(ItemMaterials, 1, 1));
		OreDictionary.registerOre("ingotSoulium", new ItemStack(ItemMaterials, 1, 2));
		OreDictionary.registerOre("dustVile", new ItemStack(ItemMaterials, 1, 3));
		OreDictionary.registerOre("essenceCorrupted", new ItemStack(ItemMaterials, 1, 4));
		OreDictionary.registerOre("stickPetrified", new ItemStack(ItemMaterials, 1, 5));
	}

	private static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityForge.class, "sstow_soul_forge_tile");
		GameRegistry.registerTileEntity(TileEntityCage.class, "sstow_soul_cage_tile");
	}

	private static void registerRecipes() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 9, 2), BlockSoulium));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 9, 1), "ingotSoulium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 9, 0), "ingotIron"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockForge), "SSS", "SCS", "OOO", 'S', "cobblestone", 'C', "essenceCorrupted", 'O', Blocks.obsidian));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemMaterials, 1, 2), "AAA", "AAA", "AAA", 'A', "nuggetSoulium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.iron_ingot), "AAA", "AAA", "AAA", 'A', "nuggetIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockSoulium), "AAA", "AAA", "AAA", 'A', "ingotSoulium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemSwordSoul), "A", "A", "B", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemPickaxeSoul), "AAA", "CBC", "CBC", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemAxeSoul), "AA", "AB", "CB", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemHoeSoul), "AA", "CB", "CB", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemSpadeSoul), "A", "B", "B", 'A', "ingotSoulium", 'B', "stickPetrified"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockCage), "SIS", "IXI", "SIS", 'I', Blocks.iron_bars, 'S', "ingotSoulium"));

		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 0), new ItemStack(BlockPetrified, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 1), new ItemStack(BlockPetrified, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 2), new ItemStack(BlockPetrified, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 3), new ItemStack(BlockPetrified, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 4), new ItemStack(BlockPetrified2, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(BlockPetrifiedPlanks, 4, 5), new ItemStack(BlockPetrified2, 1, 1));
		/*macuahuitl based recipes */
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemClubPetr), "A", "A", "B", 'A', "BlockPetrifiedPlanks", 'B', "stickPetrified"));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemMacuPetr), new ItemStack(ItemMaterials,8,6), new ItemStack(ItemClubPetr));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClubIron), new ItemStack(ItemMaterials,4,2), new ItemStack(ItemClubPetr));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemMacuIron), new ItemStack(ItemMaterials,4,2), new ItemStack(ItemMacuPetr));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemMacuIron), new ItemStack(ItemMaterials,8,6), new ItemStack(ItemClubIron));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClubSoul), new ItemStack(ItemMaterials,4,2), new ItemStack(ItemClubIron));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemMacuSoul), new ItemStack(ItemMaterials,4,2), new ItemStack(ItemMacuIron));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemMacuSoul), new ItemStack(ItemMaterials,8,6), new ItemStack(ItemClubSoul));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemClubXogu), new ItemStack(Items.dye,  4,  5), new ItemStack(ItemClubSoul));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemMacuXogu), new ItemStack(Items.dye,  4,  5), new ItemStack(ItemMacuSoul));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemMacuXogu), new ItemStack(ItemMaterials,8,6), new ItemStack(ItemClubXogu));
		
		
		
		if (Loader.isModLoaded("Natura")) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 2, 3), Blocks.soul_sand, "dustGlowstone"));
			GameRegistry.addSmelting(new ItemStack(ItemMaterials, 1, 3), new ItemStack(ItemMaterials, 1, 4), 0.35F);
		} else {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemMaterials, 1, 4), "dustGlowstone", "dustVile"));
			GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(ItemMaterials, 1, 3), 0.35F);
		}
	}
	
//	private static void registerRenders() {
//		TileEntitySpecialRenderer renderAnvil = new RenderSoulAnvil();
//	}
	
}
