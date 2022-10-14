package org.d20CombatTracker.kotlin.lib


interface Entity {

    fun getAbilityScore(abilityType: AbilityType): Int;
    fun getAbilityModifier(abilityType: AbilityType): Int;
}