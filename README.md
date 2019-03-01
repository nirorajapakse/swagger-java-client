# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DataSetApi;

import java.io.File;
import java.util.*;

public class DataSetApiExample {

    public static void main(String[] args) {
        
        DataSetApi apiInstance = new DataSetApi();
        String datasetId = "datasetId_example"; // String | 
        try {
            Answer result = apiInstance.dataSetGetCheat(datasetId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DataSetApi#dataSetGetCheat");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://vautointerview.azurewebsites.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DataSetApi* | [**dataSetGetCheat**](docs/DataSetApi.md#dataSetGetCheat) | **GET** /api/{datasetId}/cheat | Get correct answer for dataset (cheat)
*DataSetApi* | [**dataSetGetDataSetId**](docs/DataSetApi.md#dataSetGetDataSetId) | **GET** /api/datasetId | Creates new dataset and returns its ID
*DataSetApi* | [**dataSetPostAnswer**](docs/DataSetApi.md#dataSetPostAnswer) | **POST** /api/{datasetId}/answer | Submit answer for dataset
*DealersApi* | [**dealersGetDealer**](docs/DealersApi.md#dealersGetDealer) | **GET** /api/{datasetId}/dealers/{dealerid} | Get information about a dealer
*VehiclesApi* | [**vehiclesGetIds**](docs/VehiclesApi.md#vehiclesGetIds) | **GET** /api/{datasetId}/vehicles | Get a list of all vehicleids in dataset
*VehiclesApi* | [**vehiclesGetVehicle**](docs/VehiclesApi.md#vehiclesGetVehicle) | **GET** /api/{datasetId}/vehicles/{vehicleid} | Get information about a vehicle


## Documentation for Models

 - [Answer](docs/Answer.md)
 - [AnswerResponse](docs/AnswerResponse.md)
 - [DatasetIdResponse](docs/DatasetIdResponse.md)
 - [DealerAnswer](docs/DealerAnswer.md)
 - [DealersResponse](docs/DealersResponse.md)
 - [VehicleAnswer](docs/VehicleAnswer.md)
 - [VehicleIdsResponse](docs/VehicleIdsResponse.md)
 - [VehicleResponse](docs/VehicleResponse.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



