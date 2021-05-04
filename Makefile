#FUNCTION
define cecho
    @echo "\033[92m$(1)\033[0m"
endef

# rcnn-fer Docker Makefile
REGISTRY_URL=so77id
VERSION=latest
DOCKER_IMAGE=cit2006-2020-01
DOCKER_CONTAINER_NAME=cit2006-1


##############################################################################
############################# DOCKER VARS ####################################
##############################################################################
# COMMANDS
DOCKER_COMMAND=docker


#HOST CPU VARS
HOST_SOURCE_PATH=$(shell pwd)

#IMAGE VARS
IMAGE_SOURCE_PATH=/home/src

# VOLUMES
DOCKER_VOLUMES = --volume=$(HOST_SOURCE_PATH):$(IMAGE_SOURCE_PATH) \
						     --workdir=$(IMAGE_SOURCE_PATH) \
						     --shm-size 8G

DOCKER_RUN_COMMAND=$(DOCKER_COMMAND) run -it --rm --name=$(DOCKER_CONTAINER_NAME) $(DOCKER_VOLUMES) $(REGISTRY_URL)/$(DOCKER_IMAGE):$(VERSION)

run r: docker-print
	@$(DOCKER_RUN_COMMAND)

#PRIVATE
docker-print psd:
	$(call cecho, "[CPU Docker] Running cpu docker image...")
