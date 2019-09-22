# AzureAD OAuth Callback

This app lets you catch the OAuth authorization code or access token returned from AzureAD.

## Prerequisites

In order to use this application, you need:

- JDK 8 installed (install by `sudo apt-get update && sudo apt install openjdk-8-jdk-headless`)

## Installation

Build with Maven

```
./mvnw clean install
```

## Execution

Set the following environment variables:

| Name | Desscription |
| --- | --- |
| TENANT_ID | AzureAD Tenant ID | 
| CLIENT_ID | AzureAD App ID for the client |
| RESOURCE_ID | AzureAD App ID for the server |
| REDIRECT_URI | e.g. `http://localhost:8080/callback` |

Run

```
./mvnw spring-boot:run
```