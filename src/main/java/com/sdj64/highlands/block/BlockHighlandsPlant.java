package com.sdj64.highlands.block;

import java.util.Random;

import com.sdj64.highlands.References;
import com.sdj64.highlands.generator.WorldGenPlants;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockHighlandsPlant extends BlockBush implements IGrowable{

	public boolean thornbush = false;
	
	public BlockHighlandsPlant(String name){
		super();
		setUnlocalizedName(References.MOD_ID + "_" + name);
		this.setCreativeTab(HighlandsBlocks.tabHighlands);
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		new WorldGenPlants(state, 6).generate(worldIn, rand, pos);
	}

	/**
     * Called When an Entity Collided with the Block
     */
	@Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		if(thornbush)
			entityIn.attackEntityFrom(DamageSource.cactus, 1);
    }
	
	
}
