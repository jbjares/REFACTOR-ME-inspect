package de.difuture.ekut.pht.inspect.controller

import de.difuture.ekut.pht.inspect.data.CommandRequest
import de.difuture.ekut.pht.inspect.service.TrainInspector
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/command")
class CommandController
@Autowired constructor(private val inspector: TrainInspector) {

    @PostMapping
    fun execute(@RequestBody command: CommandRequest) = inspector.executeCommand(command)
}
