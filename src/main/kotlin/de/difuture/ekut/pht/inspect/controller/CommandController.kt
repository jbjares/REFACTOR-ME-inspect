package de.difuture.ekut.pht.inspect.controller

import de.difuture.ekut.pht.inspect.data.CommandRequest
import de.difuture.ekut.pht.inspect.service.TrainInspector
import de.difuture.ekut.pht.lib.train.api.output.TrainResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/command")
class CommandController
@Autowired constructor(private val inspector: TrainInspector) {

    private companion object {
        val NOT_FOUND : ResponseEntity<TrainResponse> = ResponseEntity.notFound().build()
    }

    @PostMapping
    fun execute(@RequestBody command: CommandRequest): ResponseEntity<TrainResponse> =

            inspector.executeCommand(command)?.let { ResponseEntity.ok(it) } ?: NOT_FOUND
    }
