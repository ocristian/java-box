# java-box
just some java experiments

# Location Service

#### A High level CRUD service for Drivers and Passengers location and their online status.

## Table of Contents

- [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installing](#installing)
  * [Running the tests](#running-the-tests)    
- [Logs](#logs)
- [Deployment](#deployment)
- [Application Dependencies](#application-dependencies)
- [Built With](#built-with)
- [External Dependencies](#external-dependencies)
  * [Configuration](#configuration)
  * [Redis Cluster](#redis-cluster)
    * [Keys Strategy](#keys-strategy)
- [Messaging / Events](#messaging-/-events)
  * [AWS SNS](#aws-sns)
  * [AWS SQS](#aws-sqs)
  * [Kafka](#Kafka)
  * [EventBus (RabbitMQ)](#eventBus-(RabbitMQ))
- [Versioning](#versioning)
- [Contributing](#contributing)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and
 testing purposes. See deployment for notes on how to deploy the project on higher envs.

### Prerequisites

These are the things you need to run location service on your local machine.

#### Docker
To install docker, just follow the steps on [Get started with Docker.](https://docs.docker.com)

#### AWS Sandbox Authentication
You can follow these steps on how to Setup AWS Credentials

#### Env Vars
To be able to run this service in your local env, you need to setup few environment variables:
 
```
export
```

### Installing

Once you're done with the prerequisites, you can get a development env running by:
> Make sure you are authenticated on AWS Sandbox

```
mvn spring-boot:run
```
Feel free to use IntelliJ to run/debug the service.

You can try to call some of the endpoints like:

#### To create new Driver Location
```
curl -X POST \
}'
```

#### To find drivers within a location
```
curl -X GET \
```

A complete list with all service location endpoints can be found at .


### Running the tests

#### Unit tests suite

```
mvn clean test
```

#### Integration and stress tests

```
mvn clean verify
```

### Logs  
Please double check the @source and @tags to make sure you have the right app name and environment name. 


## Deployment

The build/deployment plan can be found on ..


## Application Dependencies

![Location Service Dependencies](.README/location-service-dependencies.png)


## Built With

* [Maven](https://maven.apache.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Redis Cluster](https://redis.io/topics/cluster-spec)
* [Lettuce](https://lettuce.io) as Redis Client

## External Dependencies

This service communicates with a few others services like configuration and message brokers.

### Configuration
We make use of Spring Cloud Config as configuration provider.

Please take a look at ...

##### Configuration Files
At config files.   
 

### Redis Cluster

This service makes use of Redis Cluster to store drivers and passengers data. 

#### Sandbox

```
redis-cli -h -c
```

#### Prelive
```
redis-cli -h -c
```

#### Keys Strategy

##### Drivers Keys

###### driver_loc{hash}
On this key, we store Drivers location info.

Here we have a special case to define the Redis Key. We make use of [Keys hash tags{hash}](https://redis.io/topics/cluster-spec#keys-hash-tags), this way we ensure that multiple keys are allocated in the same hash slot.

The strategy to define the hash tag is to use the Driver's location and from there extract the CellId based on level 5. With that we have the drivers stored close to each other based on their locations.
> More info about CellId and Level 5 can be found ..
 

Loading Driver's locations   
```
GEORADIUS loc 11.54 48.11237751603462698 1 km WITHCOORD WITHDIST 
```
The driver location result(DriverId, Distance to the lat-lon and his location):
```
1) 1) "1516165860"
   2) "0.6400"
   3) 1) "11.5486183762550354"
      2) "48.11237751603462698"
```  

###### driver_obj
On this key, we have a hash representation of a Driver Object.
To get the driver info, you need to pass the redis key + hash value(driverId)
```
HGET obj 9639269
```
The result will be a json representation of a driver like this:
```
{
   ...
}
```  

###### driver_online
On this key we store all online drivers(driverId) using a score by current time in millisecs. 
```
ZRANGE online 0 -1 WITHSCORES
```
The result will be a list of driverId and his score in millisecs.
```
 1) "-1065726830"
 2) "1570193125198"
 3) "1230934973"
 4) "1570193125224"
 5) "-1260087329"
 6) "1570193125250"
```  

### Messaging / Events

We use the message brokers to communicate driver's events like location and online status update.
All configuration details can be found ...

The submission of the events are managed by a feature toggle, so to make sure we are sending events, check if the
 property
 `events.enabled` is set as true for the desired environment.  

#### AWS SNS
Driver Location Update Event   
Topic name: `...`

#### AWS SQS
Driver Online Status Event   
Queue name: `...`

#### Kafka
Driver Location Update Event    
Topic name: `...`  
> More information about Kafka configuration can be found at configuration management.  

#### EventBus (RabbitMQ)
Driver Online Status Event    
Routing key: `...`  
> More information about EventBus configuration can be found at configuration management.  

## Versioning
We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Contributing
If you want to contribute or if you have any question, feel free to send us you PR or contact us on slack #upscalers.
