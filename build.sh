./mvnw clean package -Pnative  -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker
docker build -f src/main/docker/Dockerfile.native -t quay.io/qiot/qiot-sensors-emulator .
docker push quay.io/qiot/qiot-sensors-emulator
#docker run -it --rm -p 5000:5000 --net host quay.io/qiot/qiot-sensors-emulator