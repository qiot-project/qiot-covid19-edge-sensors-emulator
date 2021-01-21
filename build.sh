chmod +x mvnw
./mvnw clean package -Pnative  -Dquarkus.profile=staging -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker
docker rmi quay.io/qiotcovid19/edge-sensors-emulator:1.0.1-x86_64 --force
docker build -f src/main/docker/Dockerfile.native -t quay.io/qiotcovid19/edge-sensors-emulator:1.0.1-x86_64 .
docker push quay.io/qiotcovid19/edge-sensors-emulator:1.0.1-x86_64
#docker run -it --rm -p 8080:8080 --net host quay.io/qiot/qiot-integrator
