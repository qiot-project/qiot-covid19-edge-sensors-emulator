./mvnw clean package -Pnative  -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker
sudo podman rmi quay.io/qiotcovid19/qiot-sensors-emulator:1-x86_64 --force
sudo podman  build -f src/main/docker/Dockerfile.native -t quay.io/qiotcovid19/qiot-sensors-emulator:1-x86_64 .
sudo podman push quay.io/qiotcovid19/qiot-sensors-emulator:1-x86_64
#sudo podman run -it --rm -p 5000:5000 --net qiot-covid19-edge quay.io/qiotcovid19/qiot-sensors-emulator:1-x86_64
#curl localhost:5000/gas/all