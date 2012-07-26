package net.minecraft.src;

// DO NOT MESS WITH THE IMPORT
import java.io.*;
import java.util.*;

import net.minecraft.client.Minecraft;

// Thank you for looking at the source code.
// Note: Not all comments are correct as some are copy + pasted from some other places.
// Also, Herobrine & The Plus Sign are easter eggs. (Don't tell anybody. :D)
// Coded by coolawesomeme & nikblaze91. Textures by Shadow & pacman003.

// PM coolawesomeme the message 'icanhazcookiez?' and you will be rewarded a cookie.

// PLEASE DO NOT CHANGE ANY VALUES IF YOU DON'T KNOW WHAT YOU ARE DOING.
//This file will let you to set values to change the whole mod.

public class mod_MinecraftPlus extends BaseMod 
{
	
	protected Minecraft mc;
	public boolean multiplayer;
	
	// Blocks
	public static final Block BlockEmbroniumOre = new BlockEmbroniumOre(180,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockEmbroniumOre");
	public static final Block BlockEmbroniumBlock = new BlockEmbroniumBlock(181,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockEmbroniumBlock");
	public static final Block BlockBouncyBlock = new BlockBouncyBlock(182,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockBouncyBlock");
	public static final Block BlockBoosterBlock = new BlockBoosterBlock(183,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockBoosterBlock");
	public static final Block BlockHealBlock = new BlockHealBlock(184,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockHealBlock");
	public static final Block BlockDamageBlock = new BlockDamageBlock(185,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockDamageBlock");
	public static final Block EmbroniumTorch = new EmbroniumTorch(186, ModLoader.addOverride ("/terrain.png", "/minecraftplus/embroniumtorch.png")).setLightValue(1.0F).setHardness(1.0F).setBlockName("EmbroniumTorch").setRequiresSelfNotify();
	public static final Block BlockForceField = new BlockForceField(187,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockForceField").setRequiresSelfNotify();
	public static final Block BlockShield = new BlockPane(188, 0 , 37, Material.glass, false).setHardness(3.0F).setResistance(10.0F).setBlockName("BlockShield");		
	public static final Block BlockNull = new BlockNull(195,0).setHardness(0.0F).setResistance(1.0F).setBlockName("BlockNull");
	public static final Block BlockCamper = new BlockCamper(196,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockCamper").setRequiresSelfNotify();
	public static final Block BlockiBlock = new BlockiBlock(197,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockiBlock");
	public static final Block BlockCobbleGen = new BlockCobbleGen(198,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockCobbleGen");
	public static final Block BlockCrater = new BlockCrater(199,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockCrater");
	public static final Block BlockMiner = new BlockMiner(200,0).setHardness(2.0F).setResistance(5.0F).setBlockName("BlockMiner");
	public static final Block BlockHiddenBookshelf = new BlockHiddenBookshelf(201,35).setHardness(1.5F).setResistance(5.0F).setBlockName("BlockHiddenBookshelf");
	
	
	//Items
	public static final Item ItemMummyEgg = new ItemMummyEgg(31701).setItemName("ItemMummyEgg"); //The 4701 value is the only one that you may change (It is the Item ID)
	public static final Item ItemEmbroniumIngot = new ItemEmbroniumIngot(31702).setItemName("ItemEmbroniumIngot");  //The 4702 value is the only one that you may change (It is the Item ID)		
	public static final Item ItemEmbroniumDust = new ItemEmbroniumDust(31705).setItemName("ItemEmbroniumDust");
	public static final Item ItemHumanEgg = new ItemHumanEgg(31719).setItemName("ItemHumanEgg");
	
	//Food
    public static final Item ItemBandage = new ItemFood(31700, 8, 1F, false).setItemName("ItemBandage"); 
	public static final Item Cheese = new ItemFood(31703, 4, 1F, false).setItemName("Cheese").setContainerItem(Item.bucketEmpty);
	
	//Armor
	public static final Item embroniumHelmet = new PlusItemArmor(31710,PlusArmorMaterial.EMBRONIUM, ModLoader.addArmor("embroniumarmor"), 0).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumarmoricon1.png")).setItemName("embroniumHelmet");
	public static final Item embroniumChest = new PlusItemArmor(31711,PlusArmorMaterial.EMBRONIUM, ModLoader.addArmor("embroniumarmor"), 1).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumarmoricon2.png")).setItemName("embroniumChest");
	public static final Item embroniumPants = new PlusItemArmor (31712, PlusArmorMaterial.EMBRONIUM, ModLoader.addArmor("embroniumarmor"),2).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumarmoricon3.png")).setItemName("embroniumPants");
	public static final Item embroniumBoots = new PlusItemArmor (31713, PlusArmorMaterial.EMBRONIUM, ModLoader.addArmor("embroniumarmor"),3).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumarmoricon4.png")).setItemName("embroniumBoots");  
	
	//Toolset
	public static final Item embroniumPickaxe = (new PlusItemPickaxe (31714, PlusToolMaterial.EMBRONIUM)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumpickaxe.png")).setItemName("embroniumPickaxe");
	public static final Item embroniumSpade = (new PlusItemSpade (31715, PlusToolMaterial.EMBRONIUM)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumshovel.png")).setItemName("embroniumSpade");
	public static final Item embroniumSword = (new PlusItemSword (31716, PlusToolMaterial.EMBRONIUM)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumsword.png")).setItemName("embroniumSword");
	public static final Item embroniumAxe = (new PlusItemAxe (31717, PlusToolMaterial.EMBRONIUM)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumaxe.png")).setItemName("embroniumAxe");
	public static final Item embroniumHoe = (new PlusItemHoe (31718, PlusToolMaterial.EMBRONIUM)).setIconIndex(ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumhoe.png")).setItemName("embroniumHoe");
	
	//Textures
	public static int EmptyBottom = ModLoader.addOverride("/terrain.png", "/minecraftplus/emptybottom.png");
    public static int BouncyTop = ModLoader.addOverride("/terrain.png", "/minecraftplus/bouncytop.png");
    public static int BouncySides = ModLoader.addOverride("/terrain.png", "/minecraftplus/bouncysides.png");
    public static int EmptyWhite = ModLoader.addOverride("/terrain.png", "/minecraftplus/emptywhite.png");
    public static int BoosterBlock = ModLoader.addOverride("/terrain.png", "/minecraftplus/boosterblock.png");
	public static int Shield = ModLoader.addOverride("/terrain.png", "/minecraftplus/shield.png");
    
	//Boolean
    public boolean addBlocks;
    
    public void load()
    {
    	
    	//Creative GUI
    	ModLoader.setInGUIHook(this, true, true);
    	ModLoader.setInGameHook(this, true, true);
    	
    	//Armor
    	ModLoader.addName(embroniumHelmet, "Embronium Helmet");
    	ModLoader.addName(embroniumChest, "Embronium Chestplate");
    	ModLoader.addName(embroniumPants, "Embronium Pants");
    	ModLoader.addName(embroniumBoots, "Embronium Shoes");
    	ModLoader.addRecipe(new ItemStack (embroniumHelmet, 1), (new Object[] {"XXX", "X X","   ", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot}));
    	ModLoader.addRecipe(new ItemStack (embroniumChest, 1), (new Object[] {"X X", "XXX", "XXX", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot}));
    	ModLoader.addRecipe(new ItemStack (embroniumPants, 1), (new Object[] {"XXX", "X X", "X X", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot}));
    	ModLoader.addRecipe(new ItemStack (embroniumBoots, 1), (new Object[] {"X X", "X X", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot}));
    	
    	//Toolset
    	ModLoader.addName(embroniumAxe, "Embronium Axe");
    	ModLoader.addName(embroniumPickaxe, "Embronium Pickaxe");
    	ModLoader.addName(embroniumHoe, "Embronium Hoe");
    	ModLoader.addName(embroniumSword, "Embronium Sword");
    	ModLoader.addName(embroniumSpade, "Embronium Shovel");
    	ModLoader.addRecipe(new ItemStack (embroniumAxe, 1), (new Object[] {"XX ", "X@ "," @ ", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.stick}));
    	ModLoader.addRecipe(new ItemStack (embroniumPickaxe, 1), (new Object[] {"XXX", " @ "," @ ", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.stick}));
    	ModLoader.addRecipe(new ItemStack (embroniumHoe, 1), (new Object[] {"XX ", " @ "," @ ", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.stick}));
    	ModLoader.addRecipe(new ItemStack (embroniumSword, 1), (new Object[] {" X ", " X "," @ ", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.stick}));
    	ModLoader.addRecipe(new ItemStack (embroniumSpade, 1), (new Object[] {" X ", " @ "," @ ", Character.valueOf('X'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.stick}));
    	
    	//Blocks
    	ModLoader.addName(BlockHiddenBookshelf, "Secret Bookshelf");
        ModLoader.registerBlock(BlockHiddenBookshelf);
        ModLoader.addRecipe(new ItemStack(BlockHiddenBookshelf, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), Item.book, Character.valueOf('@'), Item.redstone});
        BlockEmbroniumOre.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/embroniumore.png");
        ModLoader.addName(BlockEmbroniumOre, "Embronium Ore");
        ModLoader.registerBlock(BlockEmbroniumOre);
        BlockiBlock.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/iblock.png");
        ModLoader.addName(BlockiBlock, "iBlock");
        ModLoader.registerBlock(BlockiBlock);
        ModLoader.addRecipe(new ItemStack(BlockiBlock, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.redstone});
        BlockEmbroniumBlock.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/embroniumblock.png");
        ModLoader.addName(BlockEmbroniumBlock, "Embronium Block");
        ModLoader.registerBlock(BlockEmbroniumBlock);
        ModLoader.addRecipe(new ItemStack(BlockEmbroniumBlock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), mod_MinecraftPlus.ItemEmbroniumIngot});
        BlockForceField.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/forcefield.png");
        ModLoader.addName(BlockForceField, "Force Field");
        ModLoader.registerBlock(BlockForceField);
        ModLoader.addRecipe(new ItemStack(BlockForceField, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), Block.thinGlass, Character.valueOf('@'), Item.redstone});
        BlockCamper.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/tent.png");
        ModLoader.addName(BlockCamper, "Tent Block");
        ModLoader.registerBlock(BlockCamper);
        ModLoader.addRecipe(new ItemStack(BlockCamper, 1), new Object [] {"#$#", "#@#", "!%&", Character.valueOf('#'), Block.planks, Character.valueOf('@'), Item.bed, Character.valueOf('$'), Block.glass, Character.valueOf('!'), Block.stoneOvenIdle, Character.valueOf('&'), Block.workbench, Character.valueOf('%'), Block.chest});
        BlockCobbleGen.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/cobblegen.png");
        ModLoader.addName(BlockCobbleGen, "Cobblestone Generator");
        ModLoader.registerBlock(BlockCobbleGen);
        ModLoader.addRecipe(new ItemStack(BlockCobbleGen, 1), new Object [] {"#@#", "###", "#$#", Character.valueOf('#'), Block.stone, Character.valueOf('@'), Item.bucketLava, Character.valueOf('$'), Item.bucketWater});
        BlockCrater.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/craterblock.png");
        ModLoader.addName(BlockCrater, "Crater Block");
        ModLoader.registerBlock(BlockCrater);
        ModLoader.addRecipe(new ItemStack(BlockCrater, 2), new Object [] {"$#$", "#@#", "$#$", Character.valueOf('#'), Block.sand, Character.valueOf('@'), Item.redstone, Character.valueOf('$'), Item.gunpowder});
        BlockMiner.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/minerblock.png");
        ModLoader.addName(BlockMiner, "Miner Block");
        ModLoader.registerBlock(BlockMiner);
        ModLoader.addRecipe(new ItemStack(BlockMiner, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.pickaxeSteel});
        ModLoader.addRecipe(new ItemStack(BlockMiner, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.pickaxeDiamond});
        ModLoader.addRecipe(new ItemStack(BlockMiner, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), Item.pickaxeGold});
        ModLoader.addRecipe(new ItemStack(BlockMiner, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), mod_MinecraftPlus.ItemEmbroniumIngot, Character.valueOf('@'), mod_MinecraftPlus.embroniumPickaxe});
        BlockShield.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/shield.png");
        ModLoader.addName(BlockShield, "Shield Block");
        ModLoader.registerBlock(BlockShield);
        ModLoader.addName(BlockBoosterBlock, "Booster Block");
        ModLoader.registerBlock(BlockBoosterBlock);
        ModLoader.addRecipe(new ItemStack(BlockBoosterBlock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), Block.ice});
        BlockDamageBlock.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/damageblock.png");
        ModLoader.addName(BlockDamageBlock, "Damage Block");
        ModLoader.registerBlock(BlockDamageBlock);
        ModLoader.addRecipe(new ItemStack(BlockDamageBlock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), Block.cactus});
        BlockHealBlock.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/healblock.png");
        ModLoader.addName(BlockHealBlock, "Healer Block");
        ModLoader.registerBlock(BlockHealBlock);
        ModLoader.addRecipe(new ItemStack(BlockHealBlock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), Item.cake});
        ModLoader.addName(BlockBouncyBlock, "Trampoline");
        ModLoader.registerBlock(BlockBouncyBlock);
        ModLoader.addRecipe(new ItemStack(BlockBouncyBlock, 1), new Object [] {"   ", "###", "@ @", Character.valueOf('#'), Block.cloth, Character.valueOf('@'), Item.stick});
        ModLoader.addRecipe(new ItemStack(Block.ice, 1), new Object [] {"   ", " # ", " @ ", Character.valueOf('#'), Item.snowball, Character.valueOf('@'), Item.bucketWater});
        BlockNull.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/minecraftplus/emptybottom.png");
        ModLoader.addName(BlockNull, "Null Block");
        ModLoader.registerBlock(BlockNull);
        ModLoader.addShapelessRecipe(new ItemStack(ItemEmbroniumIngot, 9), new Object[] { /*ingredients*/ mod_MinecraftPlus.BlockEmbroniumBlock});
        
        //Items
        ItemEmbroniumDust.iconIndex = ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumdust.png"); //DO NOT CHANGE
        ModLoader.addName(ItemEmbroniumDust, "Embronium Dust");
        ModLoader.registerBlock(EmbroniumTorch);
        ModLoader.addName(EmbroniumTorch, "Embronium Torch");
        ModLoader.addRecipe(new ItemStack(EmbroniumTorch, 4), new Object [] {"   ", " # ", " @ ", Character.valueOf('#'), mod_MinecraftPlus.ItemEmbroniumDust, Character.valueOf('@'), Item.stick});
        ItemMummyEgg.iconIndex = ModLoader.addOverride("/gui/items.png", "/minecraftplus/mummyegg.png"); //DO NOT CHANGE
        ModLoader.addName(ItemMummyEgg, "\u00a76Mummy Egg");  //This sets the in-game name for Mummy Eggs (The word in "" marks)
        ModLoader.addRecipe(new ItemStack(ItemMummyEgg, 2), new Object [] {"###", "#@#", "###", Character.valueOf('#'), mod_MinecraftPlus.ItemBandage, Character.valueOf('@'), Item.egg});  //This is the recipe for mummy eggs
        ItemEmbroniumIngot.iconIndex = ModLoader.addOverride("/gui/items.png", "/minecraftplus/embroniumingot.png"); //DO NOT CHANGE
        ModLoader.addName(ItemEmbroniumIngot, "Embronium Ingot");  
        ModLoader.addShapelessRecipe(new ItemStack(ItemEmbroniumDust), new Object[] { /*ingredients*/ mod_MinecraftPlus.ItemEmbroniumIngot});
        ItemHumanEgg.iconIndex = ModLoader.addOverride("/gui/items.png", "/minecraftplus/humanegg.png"); //DO NOT CHANGE
        ModLoader.addName(ItemHumanEgg, "\u00A7bHuman Egg");  //This sets the in-game name for Mummy Eggs (The word in "" marks)
        ModLoader.addRecipe(new ItemStack(ItemHumanEgg, 2), new Object [] {"###", "#@#", "###", Character.valueOf('#'), Item.cookie, Character.valueOf('@'), Item.egg});  //This is the recipe for human eggs
        
        //Food
        Cheese.iconIndex = ModLoader.addOverride("/gui/items.png", "/minecraftplus/cheese.png"); //DO NOT CHANGE
        ModLoader.addName(Cheese, "Cheese"); 
        ModLoader.addShapelessRecipe(new ItemStack(Cheese), new Object[] { /*ingredients*/ Item.bucketMilk});
        ItemBandage.iconIndex = ModLoader.addOverride("/gui/items.png", "/minecraftplus/bandage.png"); //DO NOT CHANGE
        ModLoader.addName(ItemBandage, "Bandage");  //This sets the in-game name for Bandages (The word in "" marks)
        ModLoader.addRecipe(new ItemStack(ItemBandage, 2), new Object [] {"   ", "#  ", "#  ", Character.valueOf('#'), Item.silk});  //This is the recipe for bandages (Note: They can also be collected from Mummies.)
        
        //Mobs
        ModLoader.registerEntityID (EntityHerobrine.class, "Herobrine", ModLoader.getUniqueEntityId());  //DO NOT CHANGE
        ModLoader.addSpawn (EntityHerobrine.class, 6, 1, 1, EnumCreatureType.monster);
        ModLoader.registerEntityID (EntityHumans.class, "Human", ModLoader.getUniqueEntityId());  //DO NOT CHANGE
        ModLoader.addSpawn (EntityHumans.class, 15, 5, 15, EnumCreatureType.creature);
        ModLoader.registerEntityID (EntityMummy.class, "Mummy", ModLoader.getUniqueEntityId());  //DO NOT CHANGE
        ModLoader.addSpawn (EntityMummy.class, 15, 5, 15, EnumCreatureType.monster,  new BiomeGenBase[]
        		{  
            BiomeGenBase.desert,
            BiomeGenBase.desertHills
        		});
        
        //Smelting
        ModLoader.addSmelting(BlockEmbroniumOre.blockID, new ItemStack(ItemEmbroniumIngot, 1));
    }

	// This makes the shape of the mummy (DON'T CHANGE)
    public void AddRenderer (Map map)
    {
    	map.put(EntityMummy.class, new RenderBiped(new ModelBiped(), 0.5F));
    	map.put(EntityHerobrine.class, new RenderBiped(new ModelBiped(), 0.5F));
    	map.put(EntityHumans.class, new RenderBiped(new ModelBiped(), 0.5F));
    }
    
    
    //Creative GUI
    public boolean onTickInGame(float f, Minecraft minecraft) 
    {
		if(minecraft.currentScreen == null)
		{
		  addBlocks = false;	
		}
		
		return true;
    }
    
    
    public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen screen)
    {
    	if (screen instanceof GuiContainerCreative)
    	{
    		if (addBlocks == false)
    				{
    			      Container container = ((GuiContainer)screen).inventorySlots;
    			      List list = ((ContainerCreative)container).itemList;
    			      list.add(new ItemStack(BlockEmbroniumOre));
    			      list.add(new ItemStack(BlockEmbroniumBlock));
    			      list.add(new ItemStack(EmbroniumTorch));
    			      list.add(new ItemStack(BlockBouncyBlock));
    			      list.add(new ItemStack(BlockHealBlock));
    			      list.add(new ItemStack(BlockDamageBlock));
    			      list.add(new ItemStack(BlockBoosterBlock));
    			      list.add(new ItemStack(BlockShield));
    			      list.add(new ItemStack(BlockForceField));
    			      list.add(new ItemStack(BlockCamper));
    			      list.add(new ItemStack(BlockCobbleGen));
    			      list.add(new ItemStack(BlockCrater));
    			      list.add(new ItemStack(BlockMiner));
    			      list.add(new ItemStack(BlockiBlock));
    			      list.add(new ItemStack(BlockHiddenBookshelf));
    				}
    		addBlocks = true;
    		}
    	return true;
    }
    
    //Generation
    public void generateSurface(World world, Random rand, int chunkX, int chunkZ, int x, int y, Random random)
    {
            // Embronium Ore
    	    for(int i = 0; i < 20; i++)
            {
                    int randPosX = chunkX + rand.nextInt(15);
                    int randPosY = rand.nextInt(80);
                    int randPosZ = chunkZ + rand.nextInt(16);
                    (new WorldGenMinable(mod_MinecraftPlus.BlockEmbroniumOre.blockID, 12)).generate(world, rand, randPosX, randPosY, randPosZ);
            }
    	    
    	    // Plus Generation
    	    for(int k = 0; k < 50; k++)
            {
                  int RandPosX = x + random.nextInt(5);
                  int RandPosY = random.nextInt(128);
                  int RandPosZ = y + random.nextInt(5);
                  (new WorldGenPlusSign()).generate(world, rand, RandPosX, RandPosY, RandPosZ);
            }
    }
    
    //Fuel
    public int addFuel(int i, int j)
    {
      if(i == ItemEmbroniumDust.shiftedIndex)
       return 200;
      
      if(i == ItemEmbroniumIngot.shiftedIndex)
          return 400;

      return 0;
    }
    
	//Version Of Mod (For ModLoader Error Reports)
    public String getVersion()
      {
              return "For Minecraft Version: 1.2.5 |" +
              		" Mod Version: 1.3 |" + 
            		  " bit.ly/MCPlus";
        }
	
}