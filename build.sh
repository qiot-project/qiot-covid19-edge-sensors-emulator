./mvnw clean package -Pnative  -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker
docker rmi quay.io/qiot/qiot-sensors-emulator:1-x86_64 --force
docker build -f src/main/docker/Dockerfile.native -t quay.io/qiot/qiot-sensors-emulator:1-x86_64 .
docker push quay.io/qiot/qiot-sensors-emulator:1-x86_64
#docker run -it --rm -p 5000:5000 --net host quay.io/qiot/qiot-sensors-emulator