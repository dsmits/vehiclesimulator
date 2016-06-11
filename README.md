<h1>VEHICLE SIMULATOR</h1>

Author: Djura Smits

Running the server:

Open a terminal and go to the location of vehiclesimulator.jar
Execute the following:
java -jar vehiclesimulator.jar

The server will listen to port 8000 by default. The desired port can be added as argument:
java -jar vehiclesimulator.jar 9000

The simulator can be operated through http requests:

There are several context paths that can be called:

"http://[servername]/":
The root context just returns a string
indicating you are requesting the Vehicle Simulation Server.

"http://[servername]/vehiclestatus": When requesting the
vehiclestatus context a JSON string will be returned listing the
locations and velocities of all vehicles in the simulator.
 
"http://[servername]:8000/vehicleoperate?uid=[UID]&velocityx=[VELOCITYX]&velocityy=[VELOCITYY]":
This URL is to operate the vehicle by specifying the velocities in X
and Y direction. The specified velocities are relative, the resulting
velocities are dependent on the vehicle.
       
"http://[servername]/vehicleadd:
Instantiates another vehicle

------------------------------------------------------------------------------

Running the client:

The client is implemented completely in JavaScript.
Open  simulatorClient.html in a webbrowser to use it.

Important: The client assumes the server is running on localhost on port 8000 (the default port for the server.



