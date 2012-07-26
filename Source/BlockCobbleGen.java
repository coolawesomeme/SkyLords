package net.minecraft.src;


import java.util.Random;


public class BlockCobbleGen extends Block { 
	protected BlockCobbleGen(int i, int j) {
        super(i, j, Material.wood);
    }	
	
	public int tickRate()
    {
    //How often it refreshes.  If you return 20, that's one second.
            return 10;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
            if(l > 0 && Block.blocksList[l].canProvidePower())
            {
        //Which direction the power can come from, i is the x coord, j is y, and k is z.
                    boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j - 1, k);
                    if(flag)
                    {
                            world.scheduleBlockUpdate(i, j, k, blockID, tickRate());
                    }
            }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
            if(world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j - 1, k))
            {
             //Whatever you put here is what happens when it's powered
             blockCreate(world, i, j, k);
            }
    }
	
	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
		blockRemove(world, i, j, k);
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator De-activating!");
    }
	
	 public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
	    {
		 blockRemove(world, i, j, k);
		 ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator De-activating!");
	    }
		    	    
	public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
    {
		blockRemove(world, i, j, k);
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator De-activating!");
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("\u00a76(Cause: Explosion)");
    }
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		blockCreate(world, i, j, k);
		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Cobblestone Generator Activating!");
		return blockConstructorCalled;
	}
	
	public void blockRemove(World world, int x, int y, int z)
	{
		//Generator
		world.setBlockWithNotify(x, y, z + 2, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y - 1, z + 3, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y, z + 3, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y, z + 5, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y, z + 4, mod_MinecraftPlus.BlockNull.blockID);

		//Wall
		world.setBlockWithNotify(x, y, z + 6, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x + 1, y, z + 6, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x - 1, y, z + 6, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x + 1, y, z + 5, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x - 1, y, z + 5, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x + 1, y, z + 4, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x - 1, y, z + 4, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x + 1, y, z + 3, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x - 1, y, z + 3, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x + 1, y, z + 2, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x - 1, y, z + 2, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x + 1, y, z + 1, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x - 1, y, z + 1, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y, z + 1, mod_MinecraftPlus.BlockNull.blockID);

		//Other Blocks
		world.setBlockWithNotify(x, y - 1, z + 2, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y - 1, z + 4, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y - 1, z + 5, mod_MinecraftPlus.BlockNull.blockID);
			}
	
	public void blockCreate(World world, int x, int y, int z)
	{
		//Generator
		world.setBlockWithNotify(x, y, z + 2, Block.waterMoving.blockID);
		world.setBlockWithNotify(x, y - 1, z + 3, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y, z + 3, mod_MinecraftPlus.BlockNull.blockID);
		world.setBlockWithNotify(x, y, z + 5, Block.lavaStill.blockID);
		world.setBlockWithNotify(x, y, z + 4, Block.cobblestone.blockID);
		
		//Wall
		world.setBlockWithNotify(x, y, z + 6, Block.stone.blockID);
		world.setBlockWithNotify(x + 1, y, z + 6, Block.stone.blockID);
		world.setBlockWithNotify(x - 1, y, z + 6, Block.stone.blockID);
		world.setBlockWithNotify(x + 1, y, z + 5, Block.stone.blockID);
		world.setBlockWithNotify(x - 1, y, z + 5, Block.stone.blockID);
		world.setBlockWithNotify(x + 1, y, z + 4, Block.stone.blockID);
		world.setBlockWithNotify(x - 1, y, z + 4, Block.stone.blockID);
		world.setBlockWithNotify(x + 1, y, z + 3, Block.stone.blockID);
		world.setBlockWithNotify(x - 1, y, z + 3, Block.stone.blockID);
		world.setBlockWithNotify(x + 1, y, z + 2, Block.stone.blockID);
		world.setBlockWithNotify(x - 1, y, z + 2, Block.stone.blockID);
		world.setBlockWithNotify(x + 1, y, z + 1, Block.stone.blockID);
		world.setBlockWithNotify(x - 1, y, z + 1, Block.stone.blockID);
		world.setBlockWithNotify(x, y, z + 1, Block.stone.blockID);
		
		//Other Blocks
		world.setBlockWithNotify(x, y - 1, z + 2, Block.stone.blockID);
		world.setBlockWithNotify(x, y - 1, z + 4, Block.obsidian.blockID);
		world.setBlockWithNotify(x, y - 1, z + 5, Block.stone.blockID);
			}

			
	
	public int idDropped(int i, Random random) {
        return mod_MinecraftPlus.BlockCobbleGen.blockID;
    }
}
