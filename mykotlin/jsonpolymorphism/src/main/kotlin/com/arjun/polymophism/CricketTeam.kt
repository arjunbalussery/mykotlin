package com.arjun.polymophism

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes(
    JsonSubTypes.Type(CricketTeam.India :: class),
    JsonSubTypes.Type(CricketTeam.Australia :: class),
    JsonSubTypes.Type(CricketTeam.Pakistan :: class)
)
sealed  class CricketTeam(val type: Team) {
    @JsonTypeName("INDIA")
    data class India (val players : List<Player>) : CricketTeam(Team.INDIA)

    @JsonTypeName("PAKISTAN")
    data class Pakistan (val players : List<Player>) : CricketTeam(Team.PAKISTAN)

    @JsonTypeName("AUSTRALIA")
    data class Australia (val players : List<Player>): CricketTeam(Team.AUSTRALIA)
}

data class Player(val name: String, val age: Int)

enum class Team {
    INDIA,PAKISTAN,AUSTRALIA
}
