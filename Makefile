TAG=sonar-stool
SHELLINIT=boot2docker shellinit 1>tmp; . ./tmp; rm ./tmp
ID=`$(SHELLINIT) && docker ps | grep $(TAG) | cut -f1 -d' '`

help:
	@echo "build 	- build the docker container"
	@echo "start 	- start up the container"
	@echo "login 	- give me a shell in the container"
	@echo "stop  	- stop the container"
	@echo "clean 	- delete the container"
	@echo "open  	- open sonar in your browser"

build:
	mvn package
	@$(SHELLINIT) && docker build -t $(TAG) .

start:
	@$(SHELLINIT) && docker run -p 9000:9000 -p 9092:9092 -d $(TAG)

login:
	@$(SHELLINIT) && docker exec -it $(ID) /bin/bash

stop:
	@$(SHELLINIT) && docker stop $(ID)

clean: stop
	@$(SHELLINIT) && docker rmi -f $(TAG)

open:
	open `echo $(DOCKER_HOST) | sed "s/tcp/http/g" | sed "s/:[0-9]*$$/:9000/g"`
