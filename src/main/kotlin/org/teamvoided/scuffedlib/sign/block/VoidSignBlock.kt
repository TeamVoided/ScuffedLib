package org.teamvoided.scuffedlib.sign.block

import net.minecraft.block.sign.SignBlock
import net.minecraft.util.Identifier
import net.minecraft.block.sign.SignType

class VoidSignBlock(override val texture: Identifier, settings: Settings, woodType: SignType) :
    SignBlock(settings.solid(), woodType), VoidSign

