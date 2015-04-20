package com.whammich.sstow.guide;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import amerifrance.guideapi.api.GuideRegistry;
import amerifrance.guideapi.api.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.abstraction.EntryAbstract;
import amerifrance.guideapi.api.abstraction.IPage;
import amerifrance.guideapi.api.base.Book;
import amerifrance.guideapi.api.util.PageHelper;
import amerifrance.guideapi.categories.CategoryItemStack;
import amerifrance.guideapi.entries.EntryUniText;

import com.whammich.sstow.guide.pages.PageSoulForge;
import com.whammich.sstow.utils.Register;
import com.whammich.sstow.utils.Utils;

import cpw.mods.fml.common.registry.GameRegistry;

public class SoulManual {

	public static Book SoulManual;
	public static List<CategoryAbstract> categories = new ArrayList<CategoryAbstract>();

	public static void registerguide() {
		createBook();
		SoulManual = new Book(categories, "guide.SoulManual.book.title", "guide.SoulManual.book.welcomMessage", "guide.SoulManual.book.name", new Color(102, 0, 102));
		GuideRegistry.registerBook(SoulManual);
		GameRegistry.addRecipe(new ShapedOreRecipe(GuideRegistry.getItemStackForBook(SoulManual), "C", "B", 'C', "essenceCorrupted", 'B', Items.writable_book));
	}
	
	public static void createBook(){
		List<EntryAbstract> entries = new ArrayList<EntryAbstract>();
		ArrayList<IPage> testPage = new ArrayList<IPage>();
		PageSoulForge pageSoulForge = new PageSoulForge(new ItemStack(Items.diamond));
		PageSoulForge pageSoulForge2 = new PageSoulForge(new ItemStack(Items.wheat_seeds));
		PageSoulForge pageSoulForge3 = new PageSoulForge(new ItemStack(Items.iron_ingot));
		PageSoulForge pageSoulForge4 = new PageSoulForge(new ItemStack(Blocks.iron_block));
		PageSoulForge pageSoulForge5 = new PageSoulForge(new ItemStack(Blocks.stone));
		PageSoulForge pageSoulForge6 = new PageSoulForge(new ItemStack(Blocks.log, 1, 0));
		PageSoulForge pageSoulForge7 = new PageSoulForge(new ItemStack(Blocks.log, 1, 1));
		PageSoulForge pageSoulForge8 = new PageSoulForge(new ItemStack(Blocks.log, 1, 2));
		PageSoulForge pageSoulForge9 = new PageSoulForge(new ItemStack(Blocks.log, 1, 3));
		PageSoulForge pageSoulForge10 = new PageSoulForge(new ItemStack(Blocks.log2, 1, 0));
		PageSoulForge pageSoulForge11 = new PageSoulForge(new ItemStack(Blocks.log2, 1, 1));
		PageSoulForge pageSoulForge12 = new PageSoulForge(new ItemStack(Blocks.obsidian));
		testPage.addAll(PageHelper.pagesForLongText(Utils.localize("guide.forge.opening"))); //Second
		testPage.add(pageSoulForge);
		testPage.add(pageSoulForge2);
		testPage.add(pageSoulForge3);
		testPage.add(pageSoulForge4);
		testPage.add(pageSoulForge5);
		testPage.add(pageSoulForge6);
		testPage.add(pageSoulForge7);
		testPage.add(pageSoulForge8);
		testPage.add(pageSoulForge9);
		testPage.add(pageSoulForge10);
		testPage.add(pageSoulForge11);
		testPage.add(pageSoulForge12);
		entries.add(new EntryUniText(testPage, Utils.localize("guide.forge.smelting"))); //First
		categories.add(new CategoryItemStack(entries, Utils.localize("guide.SoulManual.book.crafting"), new ItemStack(Register.BlockForge, 1, 3)));
	}
}