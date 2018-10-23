package de.difuture.ekut.pht.inspect.data

import com.fasterxml.jackson.annotation.JsonProperty
import de.difuture.ekut.pht.lib.train.api.TrainCommand
import de.difuture.ekut.pht.lib.train.api.data.TrainId
import de.difuture.ekut.pht.lib.train.api.data.TrainTag

data class CommandRequest(

        @JsonProperty("trainId")
        val trainId: TrainId,

        @JsonProperty("trainTag")
        val trainTag: TrainTag,

        @JsonProperty("command")
        val command: TrainCommand
)
