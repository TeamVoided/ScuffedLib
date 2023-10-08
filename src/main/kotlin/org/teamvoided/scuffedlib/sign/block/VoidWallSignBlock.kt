package org.teamvoided.scuffedlib.sign.block

import net.minecraft.block.sign.WallSignBlock
import net.minecraft.util.Identifier
import net.minecraft.block.sign.SignType

class VoidWallSignBlock(override val texture: Identifier, settings: Settings, woodType: SignType) :
    WallSignBlock(settings.solid(), woodType), VoidSign

