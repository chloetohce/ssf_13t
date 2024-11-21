# SSF Day 13 and Day 14 Notes

## Docker Commands

`docker --version`


`docker system prune`

Clear the docker compilation/build cache


`docker build -t <docker login>/<app name>:<version>`

Building docker image

e.g. `docker build -t chloetohce/ssf_13l:0.0.1 .`


`docker image ls`

Shows all docker images in local docker repository


`docker run -d -t -p <exposed public port>:<app server port> <image name>:<version>`

Run an image insde the container
e.g. `docker container -d -t -p 8080:3000 ssf_13l:v0.0.1`


`docker container ls`

Check if docker container is running


`docker container stop <container id>`

Stop a running container


`docker container start <container id`

Start a container


`docker rm <container id>`
To remove a stopped container


`docker rmi <image id>`
To delete an image with no running containers


## Docker compile and push to railway
1. Create a service and link the project in railway.app
2. Create the environment variable SERVER_PORT=3000
3. In your project root folder (cmd), execute `railway login --browserless`
4. `railway link` to link the project
5. Deploy the project to railway using `railway up`
    - Railway will detect that you have a dockerfile and perform the compilation. 