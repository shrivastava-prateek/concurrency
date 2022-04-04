# concurrency

This project to test the concurrency with Spring Transactions and understand the basics that how can you maintain concurrency using database locking
where there are multiple nodes connected to same DB.

## Run postgres container for DB:
docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres:alpine --max_prepared_transactions=2000 -N 2000 ![img.png](img.png)

## Run as many as nodes needed to test the concurrency: 
Use -Dserver.port=9090 as VM option to start multiple instances, change the port for each instance

## Using Jmeter we can test the concurrency: 
Open the test plan(Test Plan.jmx) in src/main/resources using Jmeter
Run - green icon
