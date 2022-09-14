# MontyHall

### To run this application you will need Java 8, Maven and Postman to run the simulation.


## Step 1: Download the project locally.
Clone the project into your local desktop to do the following instructions.

## Step 2: Build the project
To build the project you need to use the terminal and access the project directory. When inside the directory run the command to install and run tests:

```
mvn clean install
```

## Step 3: Running the Project
After installing the project you will notice that a .jar file has been created. This is the file we are going to use to start make the simulation ready.
To do that we need to use this command: 

```
mvn spring-boot:run
```
or
```
java -jar (absolute path of the .jar file)
```
## Run the simulation with Postman
To run the simulation you will need to start Postman application or another simular application to send HTTP requests.
For a successful simulation you need to send a positive number 1 or higher to this URL using POST-method:

```
localhost:8080/simulation
```

A successful run may look like this:
```
[
    "Staying:Amount of wins 351, with 35.1% chance",
    "SwitchingAmount of wins 649, with 64.9% chance"
]
```
If user send a something else other than an integer higher than 0 will result in this response:
```
Bad Request
```
