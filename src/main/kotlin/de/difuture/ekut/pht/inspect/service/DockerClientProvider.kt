package de.difuture.ekut.pht.inspect.service

import de.difuture.ekut.pht.lib.runtime.docker.spotify.SpotifyDockerClient
import org.springframework.stereotype.Service

@Service
class DockerClientProvider {

    fun getDockerClient() = SpotifyDockerClient()
}
