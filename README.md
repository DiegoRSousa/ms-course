## Create Network
```docker network create hr-net```

## Download postgres image
```docker pull postgres:12-alpine```

## Run containers
```docker run -p 5432:5432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker postgres:12-alpine```
```docker run -p 5433:5432 --name hr-user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user postgres:12-alpine```

## Config Server 
### Package
```./mvnw clean package```
### Build Image
```docker build -t hr-config-server:v1 .```
### Run container
```docker run -p 8888:8888 --name hr-config-server --network hr-net -e GITHUB_USER=diegorsousa -e GITHUB_PASS= hr-config-server:v1```
### Show logs
```docker logs -f --tail 300 hr-config-server```

## Eureka server
### Package
```./mvnw clean package```
### Build Image
```docker build -t hr-eureka-server:v1 .```
### Run container
```docker run -p 8761:8761 --name hr-eureka-server --network hr-net hr-eureka-server:v1```

## Worker
### Package
```./mvnw clean package```
### Build Image
```docker build -t hr-worker:v1 .```
### Run container
```docker run -P --network hr-net hr-worker:v1```

## User 
### Package
```./mvnw clean package```
### Build Image
```docker build -t hr-user:v1 .```
### Run container
```docker run -P --network hr-net hr-user:v1```

## Payroll
### Package
```./mvnw clean package```
### Build Image
```docker build -t hr-payroll:v1 .```
### Run container
```docker run -P --network hr-net hr-payroll:v1```

## Oauth
### Package
```./mvnw clean package```
### Build Image
```docker build -t hr-oauth:v1 .```
### Run container
```docker run -P --network hr-net hr-oauth:v1```

## API Gateway Zuul
### Package
```./mvnw clean package```
### Build Image
```docker build -t hr-api-gateway-zuul:v1 .```
### Run container
```docker run -p 8765:8765 --name hr-api-gateway-zuul --network hr-net hr-api-gateway-zuul:v1```
