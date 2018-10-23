package de.difuture.ekut.pht.inspect.service

import de.difuture.ekut.pht.inspect.data.CommandRequest
import de.difuture.ekut.pht.inspect.props.InspectRegistryProperties
import de.difuture.ekut.pht.lib.train.api.TrainCommand
import de.difuture.ekut.pht.lib.train.api.data.TrainTag
import de.difuture.ekut.pht.lib.train.api.execution.docker.PrintSummary
import de.difuture.ekut.pht.lib.train.api.output.TrainResponse
import de.difuture.ekut.pht.lib.train.registry.DefaultTrainRegistryClient
import de.difuture.ekut.pht.lib.train.station.StationInfo
import jdregistry.client.api.DockerRegistryGetClient
import jdregistry.client.auth.Authenticate
import jdregistry.client.impl.http.spring.SpringHttpGetClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class TrainInspector
@Autowired constructor(
        props: InspectRegistryProperties,
        dockerClientProvider: DockerClientProvider) {

    /**
     * The Remote Registry that the Train Inspector contacts
     */
    private val registry = DefaultTrainRegistryClient(
            dockerRegistryClient = DockerRegistryGetClient.of(
                    props.uri,
                    SpringHttpGetClient(),
                    Authenticate.with(props.username,  props.password)),
            namespace = props.namespace)


    private val docker = dockerClientProvider.getDockerClient()

    private val info = StationInfo(0, TrainTag.IMMEDIATE)

    fun executeCommand(commandRequest: CommandRequest): TrainResponse? {

        val arrival = registry.getTrainArrival(commandRequest.trainId, commandRequest.trainTag) ?: return null

        val trainOutput = when(commandRequest.command) {

            TrainCommand.PRINT_SUMMARY -> PrintSummary.execArrival(arrival, this.docker, info)

            else -> throw IllegalArgumentException("Unsupported")
        }
        return trainOutput.response
    }
}
