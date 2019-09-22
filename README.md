# AzureAD OAuth Callback

This app lets you catch the OAuth authorization code or access token returned from AzureAD.

## Installation

Build with Maven

```
$ ./mvnw clean install
```

## Execution

Set the following environment variables:

```
$ TENANT_ID=<AzureAD Tenant ID>
$ CLIENT_ID=<AzureAD Client App ID>
$ RESOURCE_ID=<AzureAD Server App ID>
$ REDIRECT_URI=http://localhost:8080/callback
```

Run

```
$ ./mvnw spring-boot:run
```